package org.formation.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MontantVirement {
	
	public double montantV;
	
	public MontantVirement() {
		super();
	}

	public MontantVirement(double montant) {
		super();
		this.montantV = montant;
	}

	public double getMontant() {
		return montantV;
	}

	public void setMontant(double montant) {
		this.montantV = montant;
	}
	
	

}
