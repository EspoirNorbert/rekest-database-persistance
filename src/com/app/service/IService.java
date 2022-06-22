package com.app.service;

import com.app.entities.Demande;
import com.app.entities.Produit;
import com.app.entities.Service;
import com.app.entities.employes.Employe;
import com.app.entities.employes.Utilisateur;

public interface IService {
	
	/**
	 * @param demande
	 * @return
	 */
	public boolean creerDemande (Utilisateur utilisateur, Demande demande);

	/**
	 * @param employe
	 */
	public void creerEmploye(Employe employe);

	/**
	 * @param produit
	 */
	public void creerProduit(Produit produit);

	/**
	 * @param serviceEntreprise
	 */
	public void creerService(Service service);
}
