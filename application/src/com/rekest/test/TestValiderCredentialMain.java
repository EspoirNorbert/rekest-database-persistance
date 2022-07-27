package com.rekest.test;

import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.employes.ChefService;
import com.rekest.exceptions.DAOException;

public class TestValiderCredentialMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDao dao = HibernateDao.getCurrentInstance();
		ChefService chefService = new ChefService("BIPOMBO", "Espoir", "espoir-b", "passer");
		try { 
			dao.save(chefService);
			System.out.println(dao.validateCredential("espoir-b", "passer"));
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
	}

}
