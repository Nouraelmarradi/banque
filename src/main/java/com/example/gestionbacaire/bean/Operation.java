package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public  class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 
	private String libelle;

	private Long montant;
	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
	private Date date;
	@ManyToOne
	private Compte comptSource;
	@ManyToOne
	private TypeOperation typeOperation;
	@ManyToOne
	private Compte comptDis;
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @return the montant
	 */
	public Long getMontant() {
		return montant;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @return the comptSource
	 */
	public Compte getComptSource() {
		return comptSource;
	}
	/**
	 * @return the typeOperation
	 */
	public TypeOperation getTypeOperation() {
		return typeOperation;
	}
	/**
	 * @return the comptDis
	 */
	public Compte getComptDis() {
		return comptDis;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @param comptSource the comptSource to set
	 */
	public void setComptSource(Compte comptSource) {
		this.comptSource = comptSource;
	}
	/**
	 * @param typeOperation the typeOperation to set
	 */
	public void setTypeOperation(TypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}
	/**
	 * @param comptDis the comptDis to set
	 */
	public void setComptDis(Compte comptDis) {
		this.comptDis = comptDis;
	}
	public Operation() {
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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	public Operation(Long montant, Date date, Compte comptSource) {
		super();
		this.montant = montant;
		this.date = date;
		this.comptSource = comptSource;
	}
	
	
	
	
	
}
