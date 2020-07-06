package com.example.gestionbacaire.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Calulcule implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int nb;
	private int  mois;
	private int nom;
	private int anne;
	
	
	/**
	 * @return the anne
	 */
	public int getAnne() {
		return anne;
	}
	/**
	 * @param anne the anne to set
	 */
	public void setAnne(int anne) {
		this.anne = anne;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the like
	
	/**
	 * @return the nb
	 */
	public int getNb() {
		return nb;
	}
	/**
	 * @return the like
	 */
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getMois() {
		return mois;
	}
	/**
	 * @return the nom
	 */
	public int getNom() {
		return nom;
	}
	/**
	 * @param nb the nb to set
	 */
	public void setNb(int nb) {
		this.nb = nb;
	}
	/**
	 * @param mois the mois to set
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(int nom) {
		this.nom = nom;
	}
	
	

}
