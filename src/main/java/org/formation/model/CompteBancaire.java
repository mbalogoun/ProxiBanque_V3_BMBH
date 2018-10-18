package org.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class CompteBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String numero;
	private String type;
	private Double solde;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "client_id")
	Client client;

	public CompteBancaire(String numero, String type, Double solde, Client client) {
		super();
		this.numero = numero;
		this.type = type;
		this.solde = solde;
		this.client = client;
	}

	public CompteBancaire(String numero, String type, Double solde) {
		super();
		this.numero = numero;
		this.type = type;
		this.solde = solde;
	}

	public CompteBancaire() {
		super();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "CompteBancaire [id=" + id + ", numero=" + numero + ", type=" + type + ", solde=" + solde + "]";
	}

}
