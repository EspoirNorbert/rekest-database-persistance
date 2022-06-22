package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.app.entities.employes.ChefService;
import com.app.entities.employes.Employe;

@Entity
public class Service {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_service")
	private int id;
	
	private String nom;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="service_id")
	private List<Employe> employes = new ArrayList<>();

	@OneToOne(targetEntity=ChefService.class)
	private ChefService chefService;
	
	public Service(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void addEmploye(Employe employe) {
		employes.add(employe);
		
		employe.setService(this);
	}
	
	public ChefService getChefService() {
		return chefService;
	}
	
	public void setChefService(ChefService chefService) {
		this.chefService = chefService;
		
		chefService.setService(this);
	}
}
