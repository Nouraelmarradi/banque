package com.example.gestionbacaire.bean;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public   class Compte implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
// communique au client un N° de compte identifiable par une série de chiffre « RIB »
private String rib;
private double  solde;
@ManyToOne
private Client client;
@ManyToOne
private Devise devise ;
@ManyToOne
 private Employe employe;

public Employe getEmploye() {
	return employe;
}






/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}


/**
 * @return the rib
 */
public String getRib() {
	return rib;
}


/**
 * @param rib the rib to set
 */
public void setRib(String rib) {
	this.rib = rib;
}


public void setEmploye(Employe employe) {
	this.employe = employe;
}

public double getSolde() {
	return solde;
}

public Client getClient() {
	return client;
}




public Devise getDevise() {
	return devise;
}

public void setSolde(double solde) {
	this.solde = solde;
}
/**
 * @param client the client to set
 */
public void setClient(Client client) {
	this.client = client;
}


public void setDevise(Devise devise) {
	this.devise = devise;
}


public Compte() {
	super();
	// TODO Auto-generated constructor stub
}


public Compte(Long id, String rib, double solde, Client client,  Devise devise, Employe employe) {
	super();
	this.id = id;
	this.rib = rib;
	this.solde = solde;
	this.client = client;
	this.devise = devise;
	this.employe = employe;
}


}
