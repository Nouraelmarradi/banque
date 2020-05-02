package com.example.Client.bean;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cheque")
public class CommandeCheque extends Commande{
private int nbPage;
private double prix;

/**
 * @return the prix
 */
public double getPrix() {
	return prix;
}


/**
 * @param prix the prix to set
 */
public void setPrix(double prix) {
	this.prix = prix;
}


public int getNbPage() {
	return nbPage;
}


public void setNbPage(int nbPage) {
	this.nbPage = nbPage;
}

public CommandeCheque() {
	super();
	// TODO Auto-generated constructor stub
}

public CommandeCheque(Long id, Date datedemmande, String ref, Client client, EtatCommande etatCommande) {
	super(id, datedemmande, ref, client, etatCommande);
	// TODO Auto-generated constructor stub
}


public CommandeCheque(Long id, Date datedemmande, String ref, Client client, EtatCommande etatCommande, int nbPage,
		double prix) {
	super(id, datedemmande, ref, client, etatCommande);
	etatCommande.setLibelle("initialle");
	this.nbPage = nbPage;
	this.prix = prix;
}


@Override
public String toString() {
	return "CommandeCheque [nbPage=" + nbPage + ", prix=" + prix + "]";
}

}
