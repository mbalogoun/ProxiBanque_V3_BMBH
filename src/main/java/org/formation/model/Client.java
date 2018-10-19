package org.formation.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String numero;
	private String nom;
	private String prenom;
	private String adresse;

	@JsonBackReference
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "conseiller_id")
	private Conseiller conseiller;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	Set<CompteBancaire> compteBancaires = new HashSet<>();

	public Client() {
		super();
	}

	public Client(String numero, String nom, String prenom, String adresse) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public Client(String numero, String nom, String prenom, String adresse, Conseiller conseiller) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.conseiller = conseiller;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Set<CompteBancaire> getCompteBancaires() {
		return compteBancaires;
	}

	public void setCompteBancaires(Set<CompteBancaire> compteBancaires) {
		this.compteBancaires = compteBancaires;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", conseiller=" + conseiller + "]";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void addCompte(CompteBancaire compte) {
		compteBancaires.add(compte);
		compte.setClient(this);
	}
}
