package com.app.entities.employes;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur {
	public Administrateur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);		
	}
}
