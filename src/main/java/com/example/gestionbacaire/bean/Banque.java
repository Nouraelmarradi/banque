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
private   Long codeBanque;
/**
 * @return the id
 */


public Long getId() {
	return id;
}



/**
 * @return the codeBanque
 */
public Long getCodeBanque() {
	return codeBanque;
}



/**
 * @param codeBanque the codeBanque to set
 */
public void setCodeBanque(Long  codeBanque) {
	this.codeBanque = codeBanque;
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
