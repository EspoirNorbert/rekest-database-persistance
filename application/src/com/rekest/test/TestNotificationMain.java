package com.rekest.test;

import java.util.ArrayList;
import java.util.List;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Demande;
import com.rekest.entities.Notification;
import com.rekest.entities.Produit;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exceptions.DAOException;
import com.rekest.notificationmanager.impl.NotificationManager;

public class TestNotificationMain {
	
	/*
	 * Cette classe permet de tester la soumission de la demande et les notification
	 */
	
	public static void main(String[] args) {
		IDao dao = HibernateDao.getCurrentInstance();
		NotificationManager daonotification = new NotificationManager();
		
		ChefService chefService = new ChefService("BIPOMBO", "Espoir", "espoir-b", "passer");
		Utilisateur utilisateur = new Utilisateur("AKINOCHO", "Ghislain", "ghislain-a", "q@$$m0rb");
		Utilisateur illiassou = new Utilisateur("Chaibou", "Illiassou", "icy", "passer");
		Demande demande = new Demande();
		Demande demande_illiassou = new Demande();
		Produit bol = new Produit("Bol");
		demande.setProduit(bol);

		demande_illiassou.setProduit(bol);
	
		try {
			
			dao.save(chefService);
			dao.save(utilisateur);
			dao.save(bol);
			utilisateur.addDemandeCreee(demande);
			utilisateur.addDemandeSoumise(demande);
			dao.save(illiassou);
			illiassou.addDemandeCreee(demande_illiassou);
			illiassou.addDemandeSoumise(demande_illiassou);
			dao.save(demande);
			dao.save(demande_illiassou);
			
			//Test de la creation de la notification
			daonotification.createNotification(chefService, demande,"Vous avez une nouvelle notification pour une demande de bol");
			daonotification.createNotification(chefService, demande_illiassou,"Vous avez une nouvelle notification pour une demande de bol");
			
			//Test de la fonction qui met la notification à "lue" 
			List<Notification> list_notif = new ArrayList<>();
			list_notif = chefService.getNotification();
			for (Notification obj : list_notif) {
				System.out.println(obj.getMessage());
				if(!obj.isRead())
					daonotification.isRead(obj);
				
			}
			
		} catch (DAOException e) {
			//
			e.printStackTrace();
		}
	}
	
}
