package fr.miniallocine.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.miniallocine.bo.Item;
import fr.miniallocine.tools.ConnectionProvider;

public class ItemDAOImpl implements ItemDAO {

	private Connection cnx;
	
	private static final String SELECT_ALL_ITEMS	 = "SELECT * FROM items";
	private static final String INSERT_ITEM = "INSERT INTO items (title,description,type,date,category) VALUES (?,?,?,?,?)";
	private static final String DELETE_ITEM = "DELETE FROM items WHERE id = ? ";
	
	public ItemDAOImpl() throws SQLException {
		cnx = ConnectionProvider.getConnection();
	}
	
	@Override
	public void insert(Item item) throws SQLException {
		PreparedStatement stmt = cnx.prepareStatement(INSERT_ITEM);
		stmt.setString(1, item.getTitle());
		stmt.setString(2, item.getDescription());
		stmt.setString(3, item.getType());
		stmt.setDate(4, Date.valueOf(item.getDate()));
		stmt.setString(5, item.getCategory());
		stmt.executeUpdate();
		cnx.close();
	}

	@Override
	public void delete(int pk) throws SQLException {
		PreparedStatement stmt = cnx.prepareStatement(DELETE_ITEM);
		stmt.setInt(1,pk);
		stmt.executeUpdate();
		cnx.close();
	}

	@Override
	public List<Item> selectAll() throws SQLException {
		List<Item> items = new ArrayList<Item>();
		Statement stmt = cnx.createStatement();
		ResultSet result = stmt.executeQuery(SELECT_ALL_ITEMS);
		
		while(result.next()) {
			
			items.add( new Item(result.getInt(1),result.getString(2),result.getString(6),result.getString(4),result.getString(3),result.getDate(5).toLocalDate()) );
			
		}
		cnx.close();
		return items;
	}

}
