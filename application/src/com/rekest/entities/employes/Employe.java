package com.rekest.entities.employes;

import java.util.ArrayList;
import java.util.List;

import com.rekest.entities.Demande;
import com.rekest.entities.Service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="employe_profil", discriminatorType=DiscriminatorType.STRING, length=64)
public class Employe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="id_employe")
	protected int id;
	protected String nom;
	protected String prenom;
	@Column(unique = true)
	protected String telephone;
	@Column(unique = true)
	protected String email;
	protected String adresse;
	
	@Column(name="employe_profil", insertable=false, updatable=false)
	protected String employeProfil;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_employe")
	private List<Demande> demandes_soumises = new ArrayList<>();
	
	@Transient
	private Service service;
	
	public Employe(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Employe(String nom, String prenom, String telephone, String email, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void addDemandeSoumise(Demande demande) {
		demandes_soumises.add(demande);
	}
	
	public static void copy(Employe employe, Employe entity) {}
}
