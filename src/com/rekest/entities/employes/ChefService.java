package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class ChefService extends Manager {
	public ChefService(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}
}
