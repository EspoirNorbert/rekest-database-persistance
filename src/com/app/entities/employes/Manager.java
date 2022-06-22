package com.app.entities.employes;

import javax.persistence.Entity;

@Entity
public class Manager extends Utilisateur {
	public Manager(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);		
	}
}
