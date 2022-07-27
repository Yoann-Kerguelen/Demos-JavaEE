package fr.miniallocine.dao;

import java.sql.SQLException;
import java.util.List;

import fr.miniallocine.bo.Item;

public interface ItemDAO {
	
	public void insert(Item item) throws SQLException;
	public void delete(int pk) throws SQLException;
	public List<Item> selectAll() throws SQLException;

}
