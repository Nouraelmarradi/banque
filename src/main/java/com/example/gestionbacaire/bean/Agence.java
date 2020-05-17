package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Agence  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private int numero;
private String libelle;
@ManyToOne
private Banque banque;
@ManyToOne
private Directeur directeur ;
@OneToMany(mappedBy = "agence")
private List<Employe> employes;

/**
 * @return the employes
 */
public List<Employe> getEmployes() {
	return employes;
}

/**
 * @param employes the employes to set
 */
public void setEmployes(List<Employe> employes) {
	this.employes = employes;
}

public Agence(Long id, int numero, String libelle, Banque banque, Directeur directeur) {
	super();
	this.id = id;
	this.numero = numero;
	this.libelle = libelle;
	this.banque = banque;
	this.directeur = directeur;
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
public int getNumero() {
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
public Directeur getDirecteur() {
	return directeur;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}
/**
 * @param numero the numero to set
 */
public void setNumero(int numero) {
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
/**
 * @param directeur the directeur to set
 */
public void setDirecteur(Directeur directeur) {
	this.directeur = directeur;
}


}
