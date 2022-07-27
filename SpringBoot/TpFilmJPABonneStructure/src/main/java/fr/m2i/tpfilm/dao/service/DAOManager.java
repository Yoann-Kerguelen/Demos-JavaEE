package fr.m2i.tpfilm.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.m2i.tpfilm.dao.DAOGenre;
import fr.m2i.tpfilm.dao.DAOMovie;
import fr.m2i.tpfilm.dao.DAOPerson;
import fr.m2i.tpfilm.dao.DAORealisator;

@Service
public class DAOManager {

	@Autowired
	@Qualifier("daoHibernateMovie")
	public DAOMovie daoMovie;

	@Autowired
	@Qualifier("daoHibernateGenre")
	public DAOGenre daoGenre;

	@Autowired
	@Qualifier("daoHibernatePerson")
	public DAOPerson daoPerson;

	@Autowired
	@Qualifier("daoHibernateRealisator")
	public DAORealisator daoRealisator;

}
