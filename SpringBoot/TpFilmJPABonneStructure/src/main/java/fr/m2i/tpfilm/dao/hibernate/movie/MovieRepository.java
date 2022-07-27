package fr.m2i.tpfilm.dao.hibernate.movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.m2i.tpfilm.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
