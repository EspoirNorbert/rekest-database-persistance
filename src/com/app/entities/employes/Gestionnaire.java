package com.app.entities.employes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.app.entities.Demande;

@Entity
public class Gestionnaire extends Utilisateur {
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="gestionnaire_id")
	private List<Demande> demandes_assignees = new ArrayList<>();

	public Gestionnaire(String nom, String prenom, String login, String password) {
		super(nom, prenom, login, password);		
	}
}
