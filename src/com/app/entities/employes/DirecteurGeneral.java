package com.app.entities.employes;

import javax.persistence.Entity;

@Entity
public class DirecteurGeneral extends Manager {
	public DirecteurGeneral(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);
	}
}
