package com.example.Client.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Directeur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id ;
private String nom;
private String prenom;
@Temporal(javax.persistence.TemporalType.DATE)
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
private Date dateNassace;
private String cin;

/**
 * @return the cin
 */
public String getCin() {
	return cin;
}

/**
 * @param cin the cin to set
 */
public void setCin(String cin) {
	this.cin = cin;
}

public Long getId() {
	return id;
}

public String getPrenom() {
	return prenom;
}

public void setId(Long id) {
	this.id = id;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public Directeur() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @return the nom
 */
public String getNom() {
	return nom;
}

/**
 * @return the dateNassace
 */
public Date getDateNassace() {
	return dateNassace;
}

/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}

/**
 * @param dateNassace the dateNassace to set
 */
public void setDateNassace(Date dateNassace) {
	this.dateNassace = dateNassace;
}

public Directeur(Long id, String nom, String prenom, Date dateNassace) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.dateNassace = dateNassace;
}


}
