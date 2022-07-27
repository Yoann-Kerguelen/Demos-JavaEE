package bo;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity

public class Trip implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tripName;
	private Integer createBy;
	private String description;
	private String date;
	private String tripHour;
	private String[] participants;
	private int numberMaxOfParticipants;
	private String placeId;
	private static final long serialVersionUID = 1L;

	public Trip() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTripHour() {
		return this.tripHour;
	}

	public void setTripHour(String tripHour) {
		this.tripHour = tripHour;
	}

	public String[] getParticipants() {
		return this.participants;
	}

	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	public int getNumberMaxOfParticipants() {
		return this.numberMaxOfParticipants;
	}

	public void setNumberMaxOfParticipants(int numberMaxOfParticipants) {
		this.numberMaxOfParticipants = numberMaxOfParticipants;
	}

	public String getPlace() {
		return this.placeId;
	}

	public void setPlace(String place) {
		this.placeId = place;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

}
