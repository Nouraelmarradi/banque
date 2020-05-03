package com.example.gestionbacaire.bean;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Card")
public class CreditCard extends Commande{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private double prix;
/**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @return the prix
 */
public double getPrix() {
	return prix;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}
/**
 * @param prix the prix to set
 */
public void setPrix(double prix) {
	this.prix = prix;
}
public CreditCard() {
	super();
	// TODO Auto-generated constructor stub
}
public CreditCard(Long id, Date datedemmande, String ref, Client client, EtatCommande etatCommande) {
	super(id, datedemmande, ref, client, etatCommande);
	// TODO Auto-generated constructor stub
}
public CreditCard(Long id, Date datedemmande, String ref, Client client, EtatCommande etatCommande, Long id2,
		double prix) {
	super(id, datedemmande, ref, client, etatCommande);
	id = id2;
	this.prix = prix;
}
@Override
public String toString() {
	return "CreditCard [id=" + id + ", prix=" + prix + "]";
}
	
}
