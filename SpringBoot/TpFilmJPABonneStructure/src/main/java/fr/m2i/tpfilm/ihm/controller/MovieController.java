package fr.m2i.tpfilm.ihm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.m2i.tpfilm.dao.service.DAOManager;
import fr.m2i.tpfilm.entities.Movie;

@Controller
public class MovieController {

	@Autowired
	DAOManager daoManager;

	@GetMapping("/accueil")
	public String displayAllMovies(Model model) {
		
		model.addAttribute("filmList", daoManager.daoMovie.selectAll());

		return "accueil";
	}

	@GetMapping(value = { "/creer-film", "/creer-film/{id}" })
	public String pageMovie(Model model, @PathVariable("id") Optional<Integer> id) {

		Movie movie = new Movie(-1, "", 0, "", null, null);

		if (id.isPresent()) {
			movie = daoManager.daoMovie.select(id.orElse(0));
		}

		model.addAttribute("film", movie);
		model.addAttribute("genreList", daoManager.daoGenre.selectAll());
		model.addAttribute("realisatorList", daoManager.daoRealisator.selectAll());

		return "creer-film";
	}

	@PostMapping("/creer-film")
	public String pagePostFilm(@ModelAttribute("film") Movie movie) {

		Movie newMovie = daoManager.daoMovie.set(movie);

		return "redirect:/film/" + newMovie.getId();
	}

	@GetMapping(value = { "/film", "/film/{id}" })
	public String pageFilmDescription(Model model, @PathVariable("id") Optional<Integer> id) {

		Movie movie = new Movie();

		if (id.isPresent()) {
			movie = daoManager.daoMovie.select(id.orElse(0));
		}

		model.addAttribute("film", movie);

		return "film";
	}

}
