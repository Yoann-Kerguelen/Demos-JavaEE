package fr.m2i.tpfilm.dao.hibernate.genre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.m2i.tpfilm.dao.DAO;

public class DAORepository<TypeEntity, TypeClePrimaire> implements DAO<TypeEntity, TypeClePrimaire> {

	@Override
	public List<TypeEntity> selectAll() {
		return (List<TypeEntity>) getRepository().findAll();
	}

	@Override
	public TypeEntity select(TypeClePrimaire pk) {
		return getRepository().findById(pk).orElse(null);
	}

	@Override
	public TypeEntity set(TypeEntity objet) {
		return getRepository().save(objet);
	}

	@Override
	public void delete(TypeClePrimaire pk) {
		getRepository().deleteById(pk);
	}
	
	public CrudRepository<TypeEntity, TypeClePrimaire> getRepository() {
		return null;
	}
}
