package com.rekest.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.rekest.entities.employes.Administrateur;
import com.rekest.entities.employes.ChefService;
import com.rekest.entities.employes.Directeur;
import com.rekest.entities.employes.DirecteurGeneral;
import com.rekest.entities.employes.Gestionnaire;
import com.rekest.entities.employes.Utilisateur;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;


public class Utilitaire {
	
	public static void alert(AlertType alertType, Window onwer, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.initOwner(onwer);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		
		alert.showAndWait();

		if (alertType == AlertType.ERROR)
			// Fatal Error, exit System !
			System.exit(-1);     		
	}

	public static Utilisateur generateLoginAndPassword(Utilisateur utilisateur) {
		utilisateur.setLogin(utilisateur.getNom() + "." +utilisateur.getPrenom()+ "@rekest.sn");
		utilisateur.setPassword(Utilitaire.setUserProfil(utilisateur));
		return utilisateur;
	}
	
	public static String setUserProfil(Utilisateur u) {
		if (u instanceof Administrateur ) return "admin";
		if (u instanceof Gestionnaire ) return "gestionnaire";
		if (u instanceof ChefService ) return "chef";
		if (u instanceof Directeur ) return "directeur";
		if (u instanceof DirecteurGeneral ) return "dg";
		return null;
	}

	public static void loadPageInRootLayout(BorderPane rootLayout ,String filename , Class<?> classe) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(classe.getResource(filename+".fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		rootLayout.setCenter(page);
	}
	
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] byteData = md.digest();
        
        //convertir le tableau de bits en une format hexad??cimal - m??thode 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
	}

}
