package fr.m2i.tpfilm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Genre")
public class Genre implements Serializable {

	/**
	 * genre v1.0
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	public Genre() {
	}

	/**
	 * @param id
	 * @param name
	 */
	public Genre(int id, String name) {
		super();
		this.id = id;
		this.setName(name);
	}

	/**
	 * @param name
	 */
	public Genre(String name) {
		super();
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
