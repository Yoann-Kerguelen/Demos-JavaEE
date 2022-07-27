package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bo.Place;

/**
 * Session Bean implementation class PlaceSession
 */
@Stateless
@LocalBean
public class PlaceSession {

	@PersistenceContext
	private EntityManager em;

	public PlaceSession() {
	}

	public void addPlace(Place place) {
		em.persist(place);
	}

	public Place getPlace(int pk) throws Exception {
		Place place = em.find(Place.class, pk);
		if (place == null)
			throw new Exception("404");// TODO: ajouter la redirection vers error 404 perso si le temps
		return place;
	}

	public void updatePlace(Place place, int pk) {
		em.createQuery("UPDATE Place p SET p.title = :title, p.address = :address WHERE p.id = :pk")
				.setParameter("title", place.getTitle()).setParameter("address", place.getAddress())
				.setParameter("pk", pk).executeUpdate();
	}

	public List<Place> getAllPlaces() {
		@SuppressWarnings("unchecked")
		List<Place> place = em.createQuery("SELECT p FROM Place p").getResultList();
		return place;
	}

	public void deletePlace(int pk) {
		Place place = em.find(Place.class, pk);
		em.remove(place);
	}

}
