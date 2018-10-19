package org.formation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Conseiller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String prenom;
	private String nom;
	private String login;
	private String password;
	@OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL)
	Set<Client> clients = new HashSet<>();

	public Conseiller() {
		super();
	}

	public Conseiller(String prenom, String nom, String login, String password) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public void addClient(Client c) {

		clients.add(c);
		c.setConseiller(this);

	}

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", login=" + login + ", password="
				+ password + "]";
	}
	
}
