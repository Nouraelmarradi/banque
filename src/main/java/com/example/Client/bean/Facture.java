package com.example.Client.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@ManyToOne
	private Compte compte ;
	private double montant;
	@ManyToOne
	private TypeFacture typeFacture;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @return the typeFacture
	 */
	public TypeFacture getTypeFacture() {
		return typeFacture;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/**
	 * @param typeFacture the typeFacture to set
	 */
	public void setTypeFacture(TypeFacture typeFacture) {
		this.typeFacture = typeFacture;
	}
	public Facture(Long id, Compte compte, double montant, TypeFacture typeFacture) {
		super();
		this.id = id;
		this.compte = compte;
		this.montant = montant;
		this.typeFacture = typeFacture;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Facture [id=" + id + ", compte=" + compte + ", montant=" + montant + ", typeFacture=" + typeFacture
				+ "]";
	}
	
}
