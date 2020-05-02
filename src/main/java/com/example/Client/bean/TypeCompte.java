package com.example.Client.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeCompte  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private double tauxInteret;
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	
	/**
	 * @return the tauxInteret
	 */
	public double getTauxInteret() {
		return tauxInteret;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @param tauxInteret the tauxInteret to set
	 */
	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	public TypeCompte(Long id, String libelle, double tauxInteret) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.tauxInteret = tauxInteret;
	}
	public TypeCompte() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TypeCompte [id=" + id + ", libelle=" + libelle + ", tauxInteret=" + tauxInteret + "]";
	}
	

}
