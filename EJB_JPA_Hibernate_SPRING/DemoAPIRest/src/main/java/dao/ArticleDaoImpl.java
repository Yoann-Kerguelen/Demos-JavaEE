package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import api.bo.Article;
import utils.ConnectionProvider;

public class ArticleDaoImpl implements ArticleDAO {
	private static final String SELECT_ALL_ARTICLES = "SELECT * FROM articles";

	@Override
	public Article selectOne(int pk) throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM articles WHERE id = ?");

		stmt.setInt(1, pk);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			return new Article(rs.getInt(pk), rs.getDouble("prix"), rs.getString("nom"));
		}
		return null;
	}

	@Override
	public List<Article> selectAll() throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		List<Article> articles = new ArrayList<Article>();

		Statement stmt = cnx.createStatement();
		ResultSet result = stmt.executeQuery(SELECT_ALL_ARTICLES);

		while (result.next()) {
			articles.add(new Article(result.getInt(1), result.getDouble(2), result.getString(3)));
		}

		return articles;
	}

	@Override
	public void addArticle(Article article) throws SQLException {
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement stmt = cnx.prepareStatement("Insert into article (nom,prix) values(?,?)");
		stmt.setString(1, article.getNom());
		stmt.setDouble(2, article.getPrix());
		stmt.executeUpdate();
	}

}
