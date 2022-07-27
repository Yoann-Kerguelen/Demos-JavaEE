package fr.m2i.tpfilm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie implements Serializable {
	/**
	 * movie v1.0
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private int duree;
	private String synopsis;

	@OneToOne
	private Genre genre;

	@OneToOne
	private Realisator realisator;

	public Movie() {
	}

	/**
	 * @param id
	 * @param nom
	 * @param duree
	 * @param synopsis
	 * @param genre
	 * @param realisateur
	 */
	public Movie(int id, String nom, int duree, String synopsis, Genre genre, Realisator realisator) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.synopsis = synopsis;
		this.genre = genre;
		this.realisator = realisator;
	}

	/**
	 * @param nom
	 * @param duree
	 * @param synopsis
	 * @param genre
	 * @param realisateur
	 */
	public Movie(String nom, int duree, String synopsis, Genre genre, Realisator realisator) {
		super();
		this.nom = nom;
		this.duree = duree;
		this.synopsis = synopsis;
		this.genre = genre;
		this.realisator = realisator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Realisator getRealisator() {
		return realisator;
	}

	public void setRealisator(Realisator realisator) {
		this.realisator = realisator;
	}

}
