package com.dashboard.demo.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Formateur")
public class Formateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "Prenom")
	private String firstName;
	
	@Column(name = "Nom")
	private String lastName;
	
	@Column(name = "Email")
	private String emailId;
	
	@Column(name = "Telephone")
	private long Telephone;
	
	@Column(name = "Domaine")
	private String Domaine;
	
	
	
	public Formateur() {
		
	}
	
	public Formateur(long id, String firstName, String lastName, String emailId, long Telephone, String Domaine) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.Telephone = Telephone;
		this.Domaine = Domaine;
	}
	
	
	
	public long getTelephone() {
		return Telephone;
	}

	public void setTelephone(long telephone) {
		Telephone = telephone;
	}

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDomaine() {
		return Domaine;
	}

	public void setDomaine(String domaine) {
		Domaine = domaine;
	}
	
	
	
}
