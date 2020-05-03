package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import org.springframework.context.annotation.Description;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_CPte",discriminatorType = DiscriminatorType.STRING)
public  class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 
	private String ref;

	private Long montant;
	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
	private Date date;
	@ManyToOne
	private Compte comptSource;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}


	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}


	public Compte getComptSource() {
		return comptSource;
	}


	

	/**
	 * @param comptSource the comptSource to set
	 */
	public void setComptSource(Compte comptSource) {
		this.comptSource = comptSource;
	}


	

	/**
	 * @return the montant
	 */
	public Long getMontant() {
		return montant;
	}


	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Long montant) {
		this.montant = montant;
	}


	
	


	
	public Date getDate() {
		return date;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Operation(String ref,  Long montant, Date date, Compte comptSource,
			Compte compteDestinaton) {
		super();
		this.ref = ref;
		this.montant = montant;
		this.date = date;
		this.comptSource = comptSource;
	}
	
}
