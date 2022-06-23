package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class Directeur extends Manager {
	public Directeur(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}
}
