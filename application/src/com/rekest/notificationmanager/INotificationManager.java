package com.rekest.notificationmanager;

import java.util.List;

import com.rekest.entities.Demande;
import com.rekest.entities.Notification;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exceptions.DAOException;

public interface INotificationManager {

	public boolean createNotification (Utilisateur utilisateur, Demande demande, String message) throws DAOException;
	
	public boolean isRead(Notification notification) throws DAOException;
	
	public boolean deleteNotification(Notification notification, Utilisateur utilisateur, Demande demande)throws DAOException;
	
}
