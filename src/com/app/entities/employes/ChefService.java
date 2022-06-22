package com.app.entities.employes;

import javax.persistence.Entity;

@Entity
public class ChefService extends Manager {
	public ChefService(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}
}
