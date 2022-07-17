package com.rekest.dao.impl;

import java.util.List;

import com.rekest.entities.Departement;
import com.rekest.exceptions.DAOException;
import com.rekest.observableList.impl.ObservableListDepartement;

import javafx.collections.ObservableList;


public class DepartementDao extends HibernateDao {

	private ObservableListDepartement departmentData;
	private static DepartementDao daoInstance = null;

	private DepartementDao() {
		departmentData = new ObservableListDepartement();
	}
	
	public static DepartementDao getCurrentInstance () {
		if (daoInstance == null) daoInstance = new DepartementDao();
		return daoInstance;
	}

	@Override
	public void save(Object entity) throws DAOException {
		super.save(entity);
		departmentData.add((Departement) entity);
	}

	@Override
	public void delete(Object entity) throws DAOException {
		super.delete(entity);
		departmentData.delete((Departement) entity);
	}

	@Override
	public List<Object> list(Object entityClass) throws DAOException {
		departmentData.clear();
		departmentData.addAll(super.list(entityClass));
		return super.list(entityClass);
	}

	
	@Override
	public ObservableList<Departement> departementlistObservable() throws DAOException {
	    return this.departmentData.getData();
	}
	
}