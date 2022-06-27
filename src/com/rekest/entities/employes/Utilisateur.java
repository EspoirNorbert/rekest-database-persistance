package com.rekest.entities.employes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.rekest.entities.Demande;
import com.rekest.entities.Notification;
import com.rekest.entities.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur extends Employe {
	
	protected String login;
	protected String password;
	protected boolean isEnable = true;
	protected Date createdAt;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="utilisateur_id")
	private List<Notification> notifications = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="utilisateur_id")
	private List<Demande> demandesCreees = new ArrayList<>();
	
	@ManyToMany(targetEntity=Role.class, cascade=CascadeType.ALL)
	protected List<Role> roles = new ArrayList<>();
	
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
