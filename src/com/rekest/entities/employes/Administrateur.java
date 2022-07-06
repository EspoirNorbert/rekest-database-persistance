package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur {
	
	
	public Administrateur(String nom, String prenom, String telephone, String email, String adresse) {
		super(nom, prenom, telephone, email, adresse);
	}
	
	
	public Administrateur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);		
	}
}
