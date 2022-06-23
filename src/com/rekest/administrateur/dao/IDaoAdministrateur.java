package com.rekest.administrateur.dao;

import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Utilisateur;

public interface IDaoAdministrateur {
	
	public default Object validateCredential(String login, String password) {return null;};
	public default void enableAccount(Utilisateur entity) {};
	public default void disableAccount(Utilisateur entity) {};
	public default void associateService(Employe employe, Service service) {};
}
