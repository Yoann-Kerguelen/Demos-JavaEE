package fr.m2i.tpfilm.dao.hibernate.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fr.m2i.tpfilm.entities.Genre;

@Service
@Qualifier("daoHibernateGenre")
public class DAOGenreRepository extends DAORepository<Genre, Integer>{

	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public CrudRepository<Genre, Integer> getRepository() {
		return genreRepository;
	}
}
