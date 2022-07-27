package fr.m2i.tpfilm.dao.hibernate.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fr.m2i.tpfilm.dao.hibernate.genre.DAORepository;
import fr.m2i.tpfilm.entities.Movie;

@Service
@Qualifier("daoHibernateMovie")
public class DAOMovieRepository extends DAORepository<Movie, Integer>{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public CrudRepository<Movie, Integer> getRepository() {
		return movieRepository;
	}
}
