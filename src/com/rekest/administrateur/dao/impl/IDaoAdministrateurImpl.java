package com.rekest.administrateur.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rekest.administrateur.dao.IDaoAdministrateur;
import com.rekest.entities.employes.Utilisateur;

public class IDaoAdministrateurImpl implements IDaoAdministrateur {

	private static Session session = null;
	private static Transaction transaction = null;
	private static IDaoAdministrateurImpl daoAdministrateurInstance = null;
	
	public static IDaoAdministrateurImpl getCurrentInstance () {
		if (daoAdministrateurInstance == null) daoAdministrateurInstance = new IDaoAdministrateurImpl();
		return daoAdministrateurInstance;
	}
//	@Override
//	public boolean enableAccount(Utilisateur entity) {
//		System.out.println("Ici la methode enableAccount de IDaoAdministrateur");
//		
//	}

//	@Override
//	public void disableAccount(Utilisateur entity) {
//		System.out.println("Ici la methode disableAccount de IDaoAdministrateur");		
//	}

	

}
