package com.example.gestionbacaire.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class Courant extends Compte {
	 private double decouvert;

public Courant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}

public Courant(Long id, String rib, double solde, Client client, Devise devise, Employe employe) {
		super(id, rib, solde, client, devise, employe);
		// TODO Auto-generated constructor stub
	}

/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

public Courant() {
	super();
	// TODO Auto-generated constructor stub
}

public Courant(Long id, String rib, double solde, Client client, Devise devise, Employe employe,double nb) {
	super(id, rib, solde, client, devise, employe);
	
	// TODO Auto-generated constructor stub
}

}
