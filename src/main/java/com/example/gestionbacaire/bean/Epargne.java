package com.example.gestionbacaire.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class Epargne extends Compte {
private int taux;

/**
 * @return the taux
 */
public int getTaux() {
	return taux;
}

/**
 * @param taux the taux to set
 */
public void setTaux(int taux) {
	this.taux = taux;
}

public Epargne() {
	super();
	// TODO Auto-generated constructor stub
}

public Epargne(Long id, String rib, double solde, Client client, Devise devise, Employe employe,int taux) {
	super(id, rib, solde, client, devise, employe);
	this.taux = taux;
	// TODO Auto-generated constructor stub
}
}
