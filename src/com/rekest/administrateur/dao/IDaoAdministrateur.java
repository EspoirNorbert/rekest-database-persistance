package com.rekest.administrateur.dao;

import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Utilisateur;

public interface IDaoAdministrateur {
	
	public default void enableAccount(Utilisateur entity) throws Exception{};
	public default void disableAccount(Utilisateur entity) throws Exception{};
	public default void associateService(Employe employe, Service service) throws Exception{};
}
