package com.rekest.entities.employes;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

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
	protected String telephone;
	protected String email;
	protected String adresse;
	@Column(name="employe_profil", insertable=false, updatable=false)
	protected String employeProfil;
	
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
	
}
