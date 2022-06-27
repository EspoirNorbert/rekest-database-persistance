package com.rekest.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Demande {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_demande")
	private int id;
	
	private String etat;
	private Date  createdAt;
	private Date updatedAt;
	
	@OneToOne(targetEntity=Produit.class)
	private Produit produit;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="demande_id")
	private List<Note> notes = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="demande_id")
	private List<Notification> notifications = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
