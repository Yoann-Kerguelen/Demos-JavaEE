package com.m2i.demo.dao.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.demo.bo.Person;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public void test() {
		// Je creer une personne et je l'insert en base
		Person personToCreate = new Person("RIALLAND", "Christophe");
		personRepository.save(personToCreate);
		
		// Select
		Optional<Person> person = personRepository.findById(1);
		
		// Si on a pas reussi à recuperer la personne alors elle est null
		Person personFixed = person.orElseGet(null);
		
		// Afficher
		System.out.println(personFixed.getLastname());
		
		// Je met a jour la person id : 1
		Person person2 = new Person(1, "LE DU", " isabelle");
		personRepository.save(person2);
		
		System.out.println("Fini");
	}
}
