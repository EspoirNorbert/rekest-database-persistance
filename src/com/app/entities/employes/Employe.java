package com.app.entities.employes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.app.entities.Demande;
import com.app.entities.Service;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) /* Pour le mapping de l'héritage avec la stratégie Single table */
@DiscriminatorColumn(name="employe_profil", discriminatorType=DiscriminatorType.STRING, length=64)
public class Employe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="id_employe")
	protected int id;
	protected String nom;
	protected String prenom;
	
	@Column(name="employe_profil", insertable=false, updatable=false)
	protected String employeProfil;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="employe_id")
	private List<Demande> demandes_soumises = new ArrayList<>();
	
	@Transient
	private Service service;
	
	public Employe(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
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
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void addDemandeSoumise(Demande demande) {
		demandes_soumises.add(demande);
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	public Service getService() {
		return service;
	}
}
