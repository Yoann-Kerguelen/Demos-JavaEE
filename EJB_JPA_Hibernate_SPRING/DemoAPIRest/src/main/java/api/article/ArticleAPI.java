package api.article;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import api.bo.Article;
import dao.Factory;

@Path("/articles")
public class ArticleAPI {

	@GET
	public Article[] getArticles() {
		Article[] articles = { new Article(1, 700, "xiaomi"), new Article(2, 900, "Samsung"),
				new Article(3, 1700, "Iphone") };

		return articles;
	}

	@GET
	@Path("/{id: \\d+}")
	public Article getArticle(@PathParam("id") int id) {
		try {
			return Factory.getArticleDAO().selectOne(id);
		} catch (SQLException e) {
			return null;
		}
	}

	@GET
	@Path("/all")
	public List<Article> getAllArticles() {
		try {
			return Factory.getArticleDAO().selectAll();
		} catch (SQLException e) {
			return null;
		}
	}

	@POST
	public Article ajouterArticle(@FormParam("nom") String nom, @FormParam("prix") String prix) {
		try {
			Factory.getArticleDAO().addArticle(new Article(Double.valueOf(prix), nom));
			return new Article(Double.valueOf(prix), nom);
		} catch (SQLException e) {
			return null;
		}
	}

	@POST
	public String ajouter(@FormParam("prenom") String prenom) {
		System.out.println(prenom);
		return prenom;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String supprimerArticle(@PathParam("id") int id) {
		return "suppression de l'id " + id;
	}

	@PUT
	@Path("/{id: \\d+}")
	public String modifierArticle(@PathParam("id") int id, @FormParam("nom") String nom) {
		return "modification de " + nom;
	}

}
