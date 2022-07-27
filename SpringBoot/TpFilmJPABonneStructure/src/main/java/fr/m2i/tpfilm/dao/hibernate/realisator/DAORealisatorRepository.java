package fr.m2i.tpfilm.dao.hibernate.realisator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import fr.m2i.tpfilm.dao.hibernate.genre.DAORepository;
import fr.m2i.tpfilm.entities.Realisator;

@Service
@Qualifier("daoHibernateRealisator")
public class DAORealisatorRepository extends DAORepository<Realisator, Integer>{

	@Autowired
	RealisatorRepository realisatorRepository;
		
	@Override
	public CrudRepository<Realisator, Integer> getRepository() {
		return realisatorRepository;
	}
	
}
