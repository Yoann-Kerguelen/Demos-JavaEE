package fr.m2i.tpfilm.dao.hibernate.realisator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.m2i.tpfilm.entities.Realisator;

@Repository
public interface RealisatorRepository extends CrudRepository<Realisator, Integer> {

}
