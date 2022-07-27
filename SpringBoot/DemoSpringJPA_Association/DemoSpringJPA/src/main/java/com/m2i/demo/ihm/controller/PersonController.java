package com.m2i.demo.ihm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.m2i.demo.bo.Person;
import com.m2i.demo.dao.repository.JobRepository;
import com.m2i.demo.dao.repository.PersonRepository;

@Controller
public class PersonController {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@GetMapping(value= {"/show-person", "/show-person/{id}"})
	public String displayPerson(Model model, @PathVariable("id") Optional<Integer> id) {
		// Il n'ya pas de id
		// -- La personne vide
		Person person = new Person(-1, "", "");
				
		// Quand il y'a un id
		if (id.isPresent()) {
			person = personRepository.findById(id.orElse(0)).orElseGet(null);
		}

		// Envoyée dans le formulaire 
		model.addAttribute("person", person);
		
		return "show_person";
	}
	
	@PostMapping("/show-person-post")
	public String showPersonPost(Model model, @ModelAttribute("person") Person person) {
		// Save
		Person personEdited = personRepository.save(person);
		
		// Redirect
		return String.format("redirect:/show-person/%d", personEdited.getId());
	}
	
	@GetMapping("/")
	public String displayAllPerson(Model model) {
		
		// la liste des job
		model.addAttribute("jobList", jobRepository.findAll());
		
		
		// la liste des personnes
		model.addAttribute("personList", personRepository.findAll());
		
		return "show_person_all";
	}
	
}
