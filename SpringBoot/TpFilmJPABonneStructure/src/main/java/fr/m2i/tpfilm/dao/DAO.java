package fr.m2i.tpfilm.dao;

import java.util.List;

public interface DAO<TypeEntity, TypeClePrimaire> {

	public List<TypeEntity> selectAll();

	public TypeEntity select(TypeClePrimaire pk);

	public TypeEntity set(TypeEntity objet);

	public void delete(TypeClePrimaire pk);
}
