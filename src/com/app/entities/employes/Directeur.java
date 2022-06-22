package com.app.entities.employes;

import javax.persistence.Entity;

@Entity
public class Directeur extends Manager {
	public Directeur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}
}
