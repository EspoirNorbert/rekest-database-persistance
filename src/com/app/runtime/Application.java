package com.app.runtime;

import com.app.dao.IDao;
import com.app.dao.impl.HibernateDao;
import com.app.entities.Demande;
import com.app.entities.Produit;
import com.app.entities.Role;
import com.app.entities.employes.Administrateur;
import com.app.entities.employes.ChefService;
import com.app.entities.employes.Utilisateur;
import com.app.service.IService;
import com.app.service.impl.Service;

public class Application {

	private static IService service;
	
	public static void main(String[] args) {
		service = Service.getInstance ();
		IDao dao = HibernateDao.getCurrentInstance();
		// creer un chef de service
		ChefService chefService = new ChefService("BIPOMBO", "Espoir", "espoir-b", "passer");
		dao.save(chefService);
		// creer service 
		com.app.entities.Service serviceEntreprise = new com.app.entities.Service ("Service Informatique");
		//serviceEntreprise.setChefService(chefService);
		//serviceEntreprise.addEmploye(chefService);		
		dao.save(serviceEntreprise);
		Utilisateur utilisateur = new Utilisateur("AKINOCHO", "Ghislain", "ghislain-a", "q@$$m0rb");
		utilisateur.setService(serviceEntreprise);
		dao.save(utilisateur);
		Role gerant = new Role("Gerant system");
		Role superviseur = new Role("Superviseur system");
		dao.update(superviseur);
		dao.save(gerant);
		gerant.setIntitule("Nouvelle modification");
		dao.update(gerant);
		dao.delete(superviseur);
		System.out.println("test test");
		dao.associateService(utilisateur, serviceEntreprise);
		com.app.entities.Service infographie = new com.app.entities.Service("Infographie");
		dao.associateService(utilisateur, infographie);
		dao.associateService(chefService, infographie);
		dao.enableAccount(utilisateur);
		dao.disableAccount(chefService);
		
		Administrateur seynabou = new Administrateur("Seynabou","Diagne","nabou","nabou");
		dao.save(seynabou);
		System.out.println(dao.validateCredential("espoir-b", "passer"));
		System.out.println(dao.validateCredential("nabou", "nabou"));
		
		Produit produit = new Produit("Ordinateur Portable 15pouces");
		//service.creerProduit(produit);
		Demande demande = new Demande();
		demande.setProduit(produit);		
		
		utilisateur.addDemandeCreee(demande);
		utilisateur.addDemandeSoumise(demande);
		
		serviceEntreprise.addEmploye(utilisateur);
		//service.creerService(serviceEntreprise);
		
//		boolean statut = service.creerDemande(utilisateur, demande);
//		if (statut) {
//			System.out.println("Demande cr��e avec succ�s !");
//		}
	}
}