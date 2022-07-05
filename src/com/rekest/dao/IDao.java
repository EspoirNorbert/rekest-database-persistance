package com.rekest.dao;

import java.util.List;

import com.rekest.administrateur.dao.IDaoAdministrateur;
import com.rekest.entities.Demande;

/**
 * @author Illiassou
 *
 */
public interface IDao extends IDaoAdministrateur {

	/**
	 * @param obj
	 * @throws Exception 
	 * @ 
	 */
		
	public void save(Object obj) throws Exception ;

	/**
	 * @param obj
	 * @throws Exception 
	 * @ 
	 */
	public void delete(Object obj) throws Exception ;

	/**
	 * @param entityClass
	 * @param primaryKey
	 * @return
	 * @throws Exception 
	 * @ 
	 */
	public Object find(Object entityClass, Integer primaryKey) throws Exception ;
	
	/**
	 * @param entityClass
	 * @return
	 * @ 
	 */
	public List<Object> list(Object entityClass) throws Exception;
	
	/**
	 * @param entityClass
	 * @return
	 * @throws Exception 
	 * @ 
	 */
	public List<Object> list(Class<?> entityClass, String whereClause) throws Exception ;
	
	/**
	 * @param entity
	 * @ 
	 */
	public void update(Object entity) throws Exception;

	/**
	 * @param entityClass
	 * @param whereClause
	 * @return
	 * @throws Exception 
	 * @ 
	 */
	public Object find(Class<?> entityClass, String whereClause) throws Exception ;
	
	/*
	 * Method qui permet de s'authentifier
	 */
	public default Object validateCredential(String login, String password) throws Exception{return null;};
	
	/*
	 * Method qui permet de definir la reponse de la demande (rejeter , cloturée ...)
	 */
	public void requestResponse(Demande demande, String reponse) throws Exception;
}
