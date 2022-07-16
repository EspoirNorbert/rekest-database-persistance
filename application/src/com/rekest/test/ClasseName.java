package com.rekest.test;
import com.rekest.entities.Demande;
import com.rekest.observableList.impl.ObservableListDepartement;
public class ClasseName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String demande = "com.rekest.observableList.impl.ObservableList"+"Employe";
		String demande = "com.rekest.entities.Demande";
		try {
			Class<?> classRandom = Class.forName(demande);
			 
				Object objectRandom = classRandom.newInstance();
				System.out.println( objectRandom);
			System.out.println("Ceci est un premier test");
			}
		catch (Exception e) {	
			e.printStackTrace();
		}
		
	}

}
