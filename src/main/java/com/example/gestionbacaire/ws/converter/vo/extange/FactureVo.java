package com.example.gestionbacaire.ws.converter.vo.extange;

import java.util.Date;


public class FactureVo {
	
	private Long id;
	private String libelle;
	private String ref;
	private Long montant;
	private Date dateFacture;
	
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}
	/**
	 * @return the dateFacture
	 */
	public Date getDateFacture() {
		return dateFacture;
	}
	/**
	 * @param dateFacture the dateFacture to set
	 */
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the montant
	 */
	public Long getMontant() {
		return montant;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	
}
