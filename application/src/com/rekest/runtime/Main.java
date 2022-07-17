package com.rekest.runtime;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Demande;
import com.rekest.entities.Note;
import com.rekest.entities.Produit;
import com.rekest.entities.Role;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Utilisateur;

public class Main {
	
	public static void main(String[] args) {
		
		IDao dao = HibernateDao.getCurrentInstance();
		ChefService chefService = new ChefService("BIPOMBO", "Espoir", "espoir-b", "passer");
		chefService.setEmail("espoir@gmail.com");
		chefService.setTelephone("784341119");
		try {
			// Test commit
			dao.save(chefService);
			Service serviceEntreprise = new Service ("Service Informatique");		
			dao.save(serviceEntreprise);
			
			
			Utilisateur utilisateur = new Utilisateur("AKINOCHO", "Ghislain", "ghislain-a", "q@$$m0rb");
			utilisateur.setEmail("gislain@gmail.com");
			dao.save(utilisateur);
			
			Role gerant = new Role("Gerant system");
			Role superviseur = new Role("Superviseur system");
			dao.save(superviseur);
			dao.save(gerant);
			gerant.setIntitule("Nouvelle modification");
			dao.update(gerant);
			dao.delete(superviseur);
			
			
			dao.associateService(utilisateur, serviceEntreprise);
			Service infographie = new Service("Infographie");
			dao.associateService(utilisateur, infographie);
			dao.associateService(chefService, infographie);
			
			dao.enableAccount(utilisateur);
			dao.disableAccount(chefService);
			
			Administrateur seynabou = new Administrateur("Seynabou","Diagne","nabou","nabou");
			dao.save(seynabou);
			
			Demande demande = new Demande();
			Produit bol = new Produit("Bol");
			dao.save(bol);
			demande.setProduit(bol);
			seynabou.addDemandeCreee(demande);
			seynabou.addDemandeSoumise(demande);
			dao.save(demande);
			Note ras = new Note("RAS");
			demande.addNote(ras);
			infographie.setChefService(chefService);
			System.out.println(utilisateur.getChefdeServiceId());
			dao.requestResponse(demande,"Rejeter");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
