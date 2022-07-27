package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bo.Trip;

/**
 * Session Bean implementation class TripSession
 */
@Stateless
@LocalBean
public class TripSession {

	@PersistenceContext
	private EntityManager em;

	public TripSession() {
	}

	public void addTrip(Trip trip) {
		em.persist(trip);
	}

	public Trip getTrip(int pk) throws Exception {
		Trip trip = em.find(Trip.class, pk);
		if (trip == null)
			throw new Exception("404");// TODO: ajouter la redirection vers error 404 perso si le temps
		return trip;
	}

	public void updateTrip(Trip trip, int pk) {
		em.createQuery(
				"UPDATE Trip t SET t.tripName = :tripName, t.createBy = :createBy, t.description = :description, t.date = :date, t.tripHour = :tripHour, t.participants = :participants, t.numberMaxOfParticipants = :numberMaxOfParticipants, t.placeId = :placeId WHERE t.id = :pk")
				.setParameter("tripName", trip.getTripName()).setParameter("createBy", trip.getCreateBy())
				.setParameter("description", trip.getDescription()).setParameter("date", trip.getDate())
				.setParameter("tripHour", trip.getTripHour()).setParameter("participants", trip.getParticipants())
				.setParameter("numberMaxOfParticipants", trip.getNumberMaxOfParticipants())
				.setParameter("placeId", trip.getPlace()).setParameter("pk", pk).executeUpdate();
	}

	public List<Trip> getAllTrips() {
		@SuppressWarnings("unchecked")
		List<Trip> trip = em.createQuery("SELECT t FROM Trip t").getResultList();
		return trip;
	}

	public void deleteTrip(int pk) {
		Trip trip = em.find(Trip.class, pk);
		em.remove(trip);
	}

}
