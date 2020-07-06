package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Agence  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private Long numero;
private String libelle;
@ManyToOne
private Banque banque;

private String  directeure ;
@Temporal(javax.persistence.TemporalType.DATE)
private Date dateCreation;
private String adress;




/**
 * @return the directeure
 */

public String getDirecteure() {
	return directeure;
}
/**
 * @param directeure the directeure to set
 */

public void setDirecteure(String directeure) {
	this.directeure = directeure;
}
public Agence(Long id, Long numero, String libelle, Banque banque, String directeure, Date dateCreation,
		String adress) {
	super();
	this.id = id;
	this.numero = numero;
	this.libelle = libelle;
	this.banque = banque;
	this.directeure = directeure;
	this.dateCreation = dateCreation;
	this.adress = adress;
}
public Date getDateCreation() {
	return dateCreation;
}
/**
 * @return the adress
 */
public String getAdress() {
	return adress;
}
/**
 * @param dateCreation the dateCreation to set
 */
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
/**
 * @param adress the adress to set
 */
public void setAdress(String adress) {
	this.adress = adress;
}

public Agence() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @return the numero
 */
public Long getNumero() {
	return numero;
}
/**
 * @return the libelle
 */
public String getLibelle() {
	return libelle;
}
/**
 * @return the banque
 */
public Banque getBanque() {
	return banque;
}
/**
 * @return the directeur
 */

public void setId(Long id) {
	this.id = id;
}
/**
 * @param numero the numero to set
 */
public void setNumero(Long numero) {
	this.numero = numero;
}
/**
 * @param libelle the libelle to set
 */
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
/**
 * @param banque the banque to set
 */
public void setBanque(Banque banque) {
	this.banque = banque;
}



}
