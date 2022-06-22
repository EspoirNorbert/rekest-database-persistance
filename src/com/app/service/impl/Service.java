package com.app.service.impl;

import com.app.administrateur.dao.IDaoAdministrateur;
import com.app.administrateur.dao.impl.IDaoAdministrateurImpl;
import com.app.dao.IDao;
import com.app.dao.impl.HibernateDao;
import com.app.entities.Demande;
import com.app.entities.Produit;
import com.app.entities.employes.ChefService;
import com.app.entities.employes.Employe;
import com.app.entities.employes.Utilisateur;
import com.app.notificationmanager.INotificationManager;
import com.app.notificationmanager.impl.NotificationManager;
import com.app.service.IService;

public class Service implements IService {

	private static IService instance;
	private IDao dao;
	private IDaoAdministrateur dao2;
	private INotificationManager notificationManager;
	
	private Service() {
		dao = HibernateDao.getCurrentInstance();
		notificationManager = new NotificationManager();
		dao2 = IDaoAdministrateurImpl.getCurrentInstance();
	}

	@Override
	public boolean creerDemande(Utilisateur utilisateur, Demande demande) {
		
		notificationManager.creerNotification(utilisateur, demande, "Une demande a �t� cr��e par vous !");
		
		com.app.entities.Service service = utilisateur.getService();
		ChefService chef = service.getChefService();		

		notificationManager.creerNotification(chef, demande, "Une nouvelle demande vous a �t� soumise !");
		
		return true;
	}

	public static IService getInstance () {
		if (instance == null) {
			instance = new Service ();
		}
		
		return instance;
	}

	@Override
	public void creerEmploye(Employe employe) {
		//dao.save(employe);
		dao.save(employe);
		
	}

	@Override
	public void creerProduit(Produit produit) {
		//dao.save(produit);
		dao.save(produit);
		
	}

	@Override
	public void creerService(com.app.entities.Service service) {
		//dao.save(service);
		dao.save(service);
		
	}
}