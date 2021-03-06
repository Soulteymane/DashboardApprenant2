package com.dashboard.demo.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import javax.persistence.Id;

@Entity
@Table(name = "liste_de_presence")
public class ListPresence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	
	@JsonFormat(pattern = "YYYY-MM-dd", shape = Shape.STRING)
	@Column(name= "Date")
	private String date;
	
	@JsonFormat(pattern = "HH:mm:ss", shape = Shape.STRING)
	@Column(name= "heure_arrive_apprenant")
	private String heure_arrive_apprenant;
	
	@JsonFormat(pattern = "HH:mm:ss", shape = Shape.STRING)
	@Column(name= "heure_depart_apprenant")
	private String heure_depart_apprenant;
	
	@Column(name= "prenom_apprenant")
	private String prenom_apprenant;
	
	@Column(name= "nom_apprenant")
	private String nom_apprenant;
	
	
	public ListPresence() {
		
	}
	
	public ListPresence(String date, String heure_arrive_apprenant, String heure_depart_apprenant,
			String prenom_apprenant, String nom_apprenant) {
		super();
		
		
		this.date = date;
		this.heure_arrive_apprenant = heure_arrive_apprenant;
		this.heure_depart_apprenant = heure_depart_apprenant;
		this.prenom_apprenant = prenom_apprenant;
		this.nom_apprenant = nom_apprenant;
	}
	
	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure_arrive_apprenant() {
		return heure_arrive_apprenant;
	}
	public void setHeure_arrive_apprenant(String heure_arrive_apprenant) {
		this.heure_arrive_apprenant = heure_arrive_apprenant;
	}
	public String getHeure_depart_apprenant() {
		return heure_depart_apprenant;
	}
	public void setHeure_depart_apprenant(String heure_depart_apprenant) {
		this.heure_depart_apprenant = heure_depart_apprenant;
	}
	public String getPrenom_apprenant() {
		return prenom_apprenant;
	}
	public void setPrenom_apprenant(String prenom_apprenant) {
		this.prenom_apprenant = prenom_apprenant;
	}
	public String getNom_apprenant() {
		return nom_apprenant;
	}
	public void setNom_apprenant(String nom_apprenant) {
		this.nom_apprenant = nom_apprenant;
	}
	
	
}
