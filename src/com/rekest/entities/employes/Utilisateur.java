package com.rekest.entities.employes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.rekest.entities.Demande;
import com.rekest.entities.Notification;
import com.rekest.entities.Role;
import com.rekest.utils.Utilitaire;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur extends Employe {
	
	protected String login;
	protected String password;
	
	@Column(name = "is_enable")
	protected boolean isEnable = true;
	
	@Basic
	@Column(name = "created_at")
	protected Date createdAt;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_utilisateur")
	private List<Notification> notifications = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_utilisateur")
	private List<Demande> demandesCreees = new ArrayList<>();
	
	@ManyToMany(targetEntity=Role.class, cascade=CascadeType.ALL)
	@JoinTable(
			joinColumns = 		 { @JoinColumn(name = "id_utilisateur") }, 
			inverseJoinColumns = { @JoinColumn(name = "id_role") }
			)
	protected List<Role> roles = new ArrayList<>();
	
	public Utilisateur(String nom, String prenom) {
		super(nom, prenom);
		this.createdAt = (Date) new java.util.Date();
		Utilitaire.generateLoginAndPassword(this);
	}

	public Utilisateur(String nom, String prenom, String telephone, String email, String adresse) {
		super(nom, prenom);
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		Utilitaire.generateLoginAndPassword(this);
	}
	
	public Utilisateur(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public void addDemandeCreee (Demande demande) {
		demandesCreees.add(demande);
	}
	
	public void addNotification (Notification notification) {
		notifications.add(notification);
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
