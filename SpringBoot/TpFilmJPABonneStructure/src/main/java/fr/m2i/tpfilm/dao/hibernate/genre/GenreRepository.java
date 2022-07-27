package fr.m2i.tpfilm.dao.hibernate.genre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.m2i.tpfilm.entities.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {

}
