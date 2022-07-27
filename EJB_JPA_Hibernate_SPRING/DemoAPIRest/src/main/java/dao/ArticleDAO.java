package dao;

import java.sql.SQLException;
import java.util.List;

import api.bo.Article;

public interface ArticleDAO {

	public Article selectOne(int pk) throws SQLException;

	public List<Article> selectAll() throws SQLException;
	
	public void addArticle(Article article) throws SQLException;
}
