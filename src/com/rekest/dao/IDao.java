package com.rekest.dao;

import java.util.List;

import com.rekest.administrateur.dao.IDaoAdministrateur;
import com.rekest.entities.employes.Utilisateur;

/**
 * @author Illiassou
 *
 */
public interface IDao extends IDaoAdministrateur {

	/**
	 * @param obj
	 * @ 
	 */
	public void save(Object obj) ;

	/**
	 * @param obj
	 * @ 
	 */
	public void delete(Object obj) ;

	/**
	 * @param entityClass
	 * @param primaryKey
	 * @return
	 * @ 
	 */
	public Object find(Object entityClass, Integer primaryKey) ;
	
	/**
	 * @param entityClass
	 * @return
	 * @ 
	 */
	public List<Object> list(Object entityClass) ;
	
	/**
	 * @param entityClass
	 * @return
	 * @ 
	 */
	public List<Object> list(Class<?> entityClass, String whereClause) ;
	
	/**
	 * @param entity
	 * @ 
	 */
	public void update(Object entity) ;

	/**
	 * @param entityClass
	 * @param whereClause
	 * @return
	 * @ 
	 */
	public Object find(Class<?> entityClass, String whereClause) ;
}
