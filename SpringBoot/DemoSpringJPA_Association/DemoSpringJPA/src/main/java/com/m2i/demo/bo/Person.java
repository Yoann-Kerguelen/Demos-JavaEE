package com.m2i.demo.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String lastname;
	private String firstname;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Address address;

	public Person() {
		
	}
	
	/**
	 * @param lastname
	 * @param firstname
	 */
	public Person(String lastname, String firstname) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
	/**
	 * @param lastname
	 * @param firstname
	 */
	public Person(int id, String lastname, String firstname) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}
	
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", lastname.toUpperCase(), firstname);
	}
	
	public String displayPersonAddesseInfo() {
		return String.format("Personne : %s - Addresse : %s", this, getAddress());
	}

	
}
