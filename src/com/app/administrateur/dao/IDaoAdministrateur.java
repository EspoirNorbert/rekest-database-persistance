package com.app.administrateur.dao;

import com.app.entities.Service;
import com.app.entities.employes.Employe;
import com.app.entities.employes.Utilisateur;

public interface IDaoAdministrateur {
	
	public default String validateCredential(String login, String password) {return null;};
	public default void enableAccount(Utilisateur entity) {};
	public default void disableAccount(Utilisateur entity) {};
	public default void associateService(Employe employe, Service service) {};
}
