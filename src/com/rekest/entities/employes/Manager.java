package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class Manager extends Utilisateur {
	public Manager(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);		
	}
}
