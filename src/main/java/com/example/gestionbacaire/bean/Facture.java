package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@ManyToOne
	private Compte compte ;
	private Long montant;
	@ManyToOne
	private TypeFacture typeFacture;
	private Date dateFacture;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	public Compte getCompte() {
		return compte;
	}
	/**
	 * @return the montant
	 */
	public Long getMontant() {
		return montant;
	}
	/**
	 * @return the typeFacture
	 */
	public TypeFacture getTypeFacture() {
		return typeFacture;
	}
	/**
	 * @return the dateFacture
	 */
	public Date getDateFacture() {
		return dateFacture;
	}
	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	/**
	 * @param typeFacture the typeFacture to set
	 */
	public void setTypeFacture(TypeFacture typeFacture) {
		this.typeFacture = typeFacture;
	}
	/**
	 * @param dateFacture the dateFacture to set
	 */
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	
	
	
}
