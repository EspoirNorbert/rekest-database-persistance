package com.rekest.test;


import com.rekest.dao.IDao;
import com.rekest.dao.impl.HibernateDao;
import com.rekest.entities.Demande;
import com.rekest.entities.Note;
import com.rekest.entities.Produit;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Utilisateur;
import com.rekest.exceptions.DAOException;

public class TestDemandeNoteMain {

	public static void main(String[] args) {
		IDao dao = HibernateDao.getCurrentInstance();
		ChefService chefService = new ChefService("BIPOMBO", "Espoir", "espoir-b", "passer");
		Utilisateur utilisateur = new Utilisateur("AKINOCHO", "Ghislain", "ghislain-a", "q@$$m0rb");
		Demande demande = new Demande();
		Produit bol = new Produit("Bol");
		demande.setProduit(bol);
		Note note1 = new Note("J'ai urgement besoin d'une reponse à ma demande");
		demande.addNote(note1);
		try {

			dao.save(chefService);
			dao.save(utilisateur);
			dao.save(bol);
			utilisateur.addDemandeCreee(demande);
			utilisateur.addDemandeSoumise(demande);
			dao.save(demande);

		} catch (DAOException e) {
			//
			e.printStackTrace();
		}
	}

}
