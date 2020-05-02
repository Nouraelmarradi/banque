package com.example.Client.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Courant extends Compte {
private double nb;

/**
 * @return the nb
 */
public double getNb() {
	return nb;
}

/**
 * @param nb the nb to set
 */
public void setNb(double nb) {
	this.nb = nb;
}

public Courant() {
	super();
	// TODO Auto-generated constructor stub
}

public Courant(Long id, String rib, double solde, Client client, Devise devise, Employe employe,double nb) {
	super(id, rib, solde, client, devise, employe);
	this.nb=nb;
	// TODO Auto-generated constructor stub
}

}
