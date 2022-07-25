package com.rekest.test;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Departement;
import com.rekest.entities.Service;
import com.rekest.entities.employes.ChefDepartement;
import com.rekest.entities.employes.ChefService;
import com.rekest.exceptions.DAOException;

public class TestDepartementMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDao dao = HibernateDao.getCurrentInstance();
		Departement IT = new Departement("IT");
		Departement IT_prime = new Departement("IT");
		try {
			ChefService espoir = new ChefService("NORBERT", "Espoir", "eunicia", "passer");
			dao.save(espoir);
			Service serviceEntreprise = new Service ("Service Informatique");		
			dao.save(serviceEntreprise);
			serviceEntreprise.setChefService(espoir);
			dao.associateDepartement(serviceEntreprise, IT);
			ChefDepartement eunicia = new ChefDepartement("DAGA", "Eunicia", "eunicia", "passer");
			dao.save(eunicia);
			IT.setChefDepartement(eunicia);
			dao.save(IT);
			dao.save(IT_prime);
		} catch (DAOException e) {
			
			e.printStackTrace();
		}

	}

}
