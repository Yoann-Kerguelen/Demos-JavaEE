package fr.m2i.tpfilm.dao.hibernate.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fr.m2i.tpfilm.dao.hibernate.genre.DAORepository;
import fr.m2i.tpfilm.entities.Person;

@Service
@Qualifier("daoHibernatePerson")
public class DAOPersonRepository extends DAORepository<Person, Integer>{

	@Autowired
	PersonRepository personRepository;
		
	@Override
	public CrudRepository<Person, Integer> getRepository() {
		return personRepository;
	}
	
}
