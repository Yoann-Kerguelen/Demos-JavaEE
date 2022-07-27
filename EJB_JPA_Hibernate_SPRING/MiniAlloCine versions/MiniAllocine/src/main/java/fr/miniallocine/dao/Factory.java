package fr.miniallocine.dao;

import java.sql.SQLException;

public class Factory {

	public static ItemDAO getItemDAO() throws SQLException {
		return new ItemDAOImpl();
	}
	
}
