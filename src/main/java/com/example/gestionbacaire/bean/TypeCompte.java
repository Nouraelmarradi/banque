package com.example.gestionbacaire.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeCompte implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private String libelle;
private double taux;
/**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @return the libelle
 */
public String getLibelle() {
	return libelle;
}
/**
 * @return the taux
 */
public double getTaux() {
	return taux;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}
/**
 * @param libelle the libelle to set
 */
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
/**
 * @param taux the taux to set
 */
public void setTaux(double taux) {
	this.taux = taux;
}
public TypeCompte(Long id, String libelle, double taux) {
	super();
	this.id = id;
	this.libelle = libelle;
	this.taux = taux;
}
public TypeCompte() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "TypeCompte [id=" + id + ", libelle=" + libelle + ", taux=" + taux + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TypeCompte other = (TypeCompte) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
