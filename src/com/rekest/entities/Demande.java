package com.rekest.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.core.util.SystemClock;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Demande {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id_demande")
	private int id;
	
	private String etat;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdAt", columnDefinition="TIMESTAMP")
	private Date  createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedAt", columnDefinition="TIMESTAMP")
	private Date updatedAt;
	
	@OneToOne(targetEntity=Produit.class)
	private Produit produit;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="demande_id")
	private List<Note> notes = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="demande_id")
	private List<Notification> notifications = new ArrayList<>();
	
	
	
	public Demande() {
		  this.createdAt = new java.util.Date();
	}

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
	
	public void addNote(Note note) {
		this.notes.add(note);
	}
//	public void addNotification(Notification notification) {
//		this.notifications.add(notification);
//	}
}
