package com.app.notificationmanager.impl;

import com.app.dao.IDao;
import com.app.dao.impl.HibernateDao;
import com.app.entities.Demande;
import com.app.entities.Notification;
import com.app.entities.employes.Utilisateur;
import com.app.notificationmanager.INotificationManager;

public class NotificationManager implements INotificationManager {

	private IDao dao = HibernateDao.getCurrentInstance();
	
	@Override
	public boolean creerNotification(Utilisateur utilisateur, Demande demande, String message) {		
		Notification notification = new Notification(message);
		dao.save(notification);
		
		utilisateur.addNotification(notification);		
		dao.update(utilisateur);
		
		return true;
	}
}
