package com.rekest.test;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.employes.ChefService;
import com.rekest.exceptions.DAOException;


public class TestAuthentificationMain {

	public static void main(String[] args) {
		
		// Classe de test de la fonction d'authentification
		
		IDao dao = HibernateDao.getCurrentInstance();
		ChefService chefService = new ChefService("BIPOMBO", "Espoir", "espoir-b", "passer");
		try {
			dao.save(chefService);
			Object obj = new Object();
			obj = dao.validateCredential("espoir-b", "passer");
			System.out.println(obj); //Affiche la reference de l'objet si trouvé null si non
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		
	}

}
