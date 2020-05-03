package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Banque  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
@OneToMany(mappedBy = "banque")
private List<Agence>agences;
/**
 * @return the id
 */


public Long getId() {
	return id;
}

/**
 * @return the agences
 */
public List<Agence> getAgences() {
	return agences;
}

/**
 * @param agences the agences to set
 */
public void setAgences(List<Agence> agences) {
	this.agences = agences;
}

public String getNom() {
	return nom;
}

public void setId(Long id) {
	this.id = id;
}
/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}

}
