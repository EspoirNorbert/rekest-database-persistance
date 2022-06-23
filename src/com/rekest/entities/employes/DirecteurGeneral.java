package com.rekest.entities.employes;

import jakarta.persistence.Entity;

@Entity
public class DirecteurGeneral extends Manager {
	public DirecteurGeneral(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}
}
