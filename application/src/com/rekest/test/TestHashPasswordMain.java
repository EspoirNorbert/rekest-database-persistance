package com.rekest.test;
import java.security.NoSuchAlgorithmException;

import com.rekest.utils.Utilitaire;
public class TestHashPasswordMain {
	
	public static void main(String[] args) {
		
		try {
			System.out.println(Utilitaire.hashPassword("admin"));
		} catch (NoSuchAlgorithmException e) {
			//
			e.printStackTrace();
		}
		
	}
}
