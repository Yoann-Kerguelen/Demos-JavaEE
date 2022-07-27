package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bo.Participant;

/**
 * Session Bean implementation class participantSession
 */
@Stateless
@LocalBean
public class ParticipantSession {

	@PersistenceContext
	private EntityManager em;

	public ParticipantSession() {
	}

	public void addParticipant(Participant participant) {
		em.persist(participant);
	}

	public Participant getParticipant(int pk) throws Exception {
		Participant participant = em.find(Participant.class, pk);
		if (participant == null)
			throw new Exception("404");// TODO: ajouter la redirection vers error 404 perso si le temps
		return participant;
	}

	public void updateParticipant(Participant participant, int pk) {
		em.createQuery(
				"UPDATE Participant p SET p.fistName = :fistName, p.lastName = :lastName, p.age = :age, p.email = :email, p.username = :username, p.password = :password WHERE p.id = :pk")
				.setParameter("fistName", participant.getFistName()).setParameter("lastName", participant.getLastName())
				.setParameter("age", participant.getAge()).setParameter("email", participant.getEmail())
				.setParameter("username", participant.getUsername()).setParameter("password", participant.getPassword())
				.setParameter("pk", pk).executeUpdate();
	}

	public List<Participant> getAllParticipants() {
		@SuppressWarnings("unchecked")
		List<Participant> participants = em.createQuery("SELECT p FROM Participant p").getResultList();
		return participants;
	}

	public void deleteParticipant(int pk) {
		Participant participant = em.find(Participant.class, pk);
		em.remove(participant);
	}

}
