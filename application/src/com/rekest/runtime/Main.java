package com.rekest.runtime;

import java.util.ArrayList;
import java.util.List;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Demande;
import com.rekest.entities.Note;
import com.rekest.entities.Notification;
import com.rekest.entities.Produit;
import com.rekest.entities.Role;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.notificationmanager.impl.NotificationManager;

public class Main {
	
	public static void main(String[] args) {
		
		IDao dao = HibernateDao.getCurrentInstance();
		NotificationManager daonotification = new NotificationManager();
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
			
			Demande demande1 = new Demande();
			Produit climatiseur = new Produit("climatiseur");
			dao.save(climatiseur);
			demande1.setProduit(climatiseur);
			seynabou.addDemandeCreee(demande1);
			seynabou.addDemandeSoumise(demande1);
			dao.save(demande1);
			
			Note ras = new Note("RAS");
			demande.addNote(ras);
			infographie.setChefService(chefService);
			System.out.println(utilisateur.getChefdeServiceId());
			dao.requestResponse(demande,"Rejeter");
			
			daonotification.createNotification(chefService, demande,"Vous avez une nouvelle notification pour une demande de bol");
			daonotification.createNotification(chefService, demande1,"Vous avez une nouvelle notification pour une demande de climatiseur");
			
			List<Notification> list_notif = new ArrayList<>();
			list_notif = chefService.getNotification();
			for (Notification obj : list_notif) {
				System.out.println(obj.getMessage());
				if(!obj.isRead())
					daonotification.isRead(obj);
				daonotification.deleteNotification(obj,chefService,demande);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
