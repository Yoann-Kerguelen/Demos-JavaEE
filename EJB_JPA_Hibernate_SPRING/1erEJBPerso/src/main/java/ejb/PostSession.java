package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bo.Post;

/**
 * Session Bean implementation class PostSession
 */
@Stateless
@LocalBean
public class PostSession {

	@PersistenceContext
	private EntityManager em;

	public PostSession() {
	}

	public void addPost(Post post) {
		em.persist(post);
	}

	public Post getPost(int pk) {

		Post p = em.find(Post.class, pk);
		// if(p==null) throw new Exception("404");
		return p;
	}

	public List<Post> getAllPosts() {
		return em.createQuery("SELECT p FROM Post p").getResultList();
	}

}
