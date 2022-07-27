package fr.m2i.tpfilm.dao.hibernate.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.m2i.tpfilm.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
