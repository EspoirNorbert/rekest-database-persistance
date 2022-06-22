package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Departement {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_departement")
	private int id;
	
	private String nom;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="departement_id")
	private List<Service> services = new ArrayList<>();
	
	public Departement(String nom) {
		this.nom = nom;
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
}
