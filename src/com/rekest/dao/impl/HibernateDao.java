package com.rekest.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rekest.dao.IDao;
import com.rekest.entities.Service;
import com.rekest.entities.employes.Employe;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.utils.HibernateSession;

public class HibernateDao implements IDao{

	public final static Logger logger = LogManager.getLogger(HibernateDao.class);
	
	private static Session session = null;
	private static Transaction transaction = null;
	private static HibernateDao daoInstance = null;
	
	private HibernateDao() {}

	public static HibernateDao getCurrentInstance () {
		if (daoInstance == null) daoInstance = new HibernateDao();
		return daoInstance;
	}
	
	/* (non-Javadoc)
	 *see com.app.sms.dao.IDao#save(java.lang.Object)
	 */
	@Override
	public void save(Object entity) {
		try {
			session = HibernateSession.getSession();
			
			//Creating Transaction Object 
			transaction = session.beginTransaction();
			logger.info("Begin transaction.");
			session.persist(entity);

			// Transaction Is Committed To Database
			transaction.commit();
			
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
	}

	/* (non-Javadoc)
	 *see com.app.sms.dao.IDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object entity) {
		try {
			session = HibernateSession.getSession();
			
			//Creating Transaction Object
			transaction = session.beginTransaction();
			logger.info("Begin transaction.");
			session.remove(entity);
			// Transaction Is Committed To Database
			transaction.commit();
			logger.info("Record is Successfully deleted.");
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
	}

	/* (non-Javadoc)
	 *see com.app.sms.dao.IDao#find(java.lang.Class, java.lang.Integer)
	 */
	@Override
	public Object find(Object entityClass, Integer primaryKey)  {
		Object entity = null;
		try {
			session = HibernateSession.getSession();
			entity = session.find(entityClass.getClass(), primaryKey);

			if (entity != null) logger.info("Record Successfully read.");
			else logger.info("Record not found.");
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		return entity;
	}
	
	/* (non-Javadoc)
	 *see com.app.sms.dao.IDao#find(java.lang.Class, java.lang.String)
	 */
	@Override
	public Object find(Class<?> entityClass, String whereClause)  {
		Object entity = null;
		try {
			session = HibernateSession.getSession();							
			
			Query<?> query = session.createQuery("From " + entityClass.getName() + " " + whereClause); 
			entity = query.getSingleResult();
			
			if (entity != null) logger.info("Record Successfully read.");
			else logger.info("Record not found.");
		} catch (Exception ignored) {}
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list(Class<?> entityClass, String whereClause)  {
		List<Object> entities = null;
		try {
			session = HibernateSession.getSession();

			Query<?> query = session.createQuery("From " + entityClass.getName() + " " + whereClause); 
			entities = (List<Object>) query.getResultList();
			
			if (entities != null) logger.info("Records Successfully read.");
			else logger.info("Records not found.");
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		return entities;
	}
	
	/* (non-Javadoc)
	 *see com.app.sms.dao.IDao#list(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list (Object entityClass) {
		List<Object> entities = null;
		try {
			session = HibernateSession.getSession();
			Query<?> query = session.createQuery("From " + entityClass.getClass().getSimpleName());

			entities = (List<Object>) query.getResultList();
			if (entities != null) logger.info("Records Successfully read.");
			else logger.info("Records not found.");
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		return entities;
	}

	/* (non-Javadoc)
	 *see com.app.sms.dao.IDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object entity) {
		try {
			session = HibernateSession.getSession();
	
			//Creating Transaction Object  
			transaction = session.beginTransaction();
			logger.info("Begin transaction.");
			session.persist(entity);
	
			// Transaction Is Committed To Database
			transaction.commit();
			logger.info("Record Successfully updated.");
		} catch (Exception exception) {
			 logger.error(exception.getMessage());
		}
	}
	
	public static void closeSession() {
		HibernateSession.close();		
	}
	
	@Override
	public void enableAccount(Utilisateur entity) {
		entity.setEnable(true);
		this.update(entity);
		
	}

	@Override
	public void disableAccount(Utilisateur entity) {
		entity.setEnable(false);
		this.update(entity);
		
	}

	@Override
	public void associateService(Employe employe, Service service) {
		
		service.addEmploye(employe);
		this.update(service);
		
	}

	@Override
	public Object validateCredential(String login, String password) {
		Object utilisateur = null;
		String whereClause = "where login = " + "'"+login+"'"+ " and password = " +"'"+password+"'"; 
		try {
			session = HibernateSession.getSession();

			@SuppressWarnings("deprecation")
			Query<?> query = session.createQuery("From Utilisateur " + whereClause); 
			utilisateur =  query.uniqueResult();
			if (utilisateur != null) logger.info("Utilisateur trouver !");
			else logger.info("utilisateur non");
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		return utilisateur;
		
	}

}