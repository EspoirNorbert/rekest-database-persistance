package com.app.notificationmanager;

import com.app.entities.Demande;
import com.app.entities.employes.Utilisateur;

public interface INotificationManager {
	
	/**
	 * @param demande
	 * @return
	 */
	public boolean creerNotification (Utilisateur utilisateur, Demande demande, String message);
}
