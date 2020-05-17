package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="commande_type")
public  class Commande implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
	private Date datedemmande;
	private String ref;
	@ManyToOne
	private Compte compte;
	@ManyToOne
    private EtatCommande etatCommande;
	@ManyToOne
	private Typecommande typecommande;
	/**
	 * @return the datedemmande
	 */
	public Date getDatedemmande() {
		return datedemmande;
	}
	/**
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}
	/**
	 * @return the etatCommande
	 */
	public EtatCommande getEtatCommande() {
		return etatCommande;
	}
	/**
	 * @return the typecommande
	 */
	public Typecommande getTypecommande() {
		return typecommande;
	}
	/**
	 * @param datedemmande the datedemmande to set
	 */
	public void setDatedemmande(Date datedemmande) {
		this.datedemmande = datedemmande;
	}
	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
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
	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	/**
	 * @param etatCommande the etatCommande to set
	 */
	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}
	/**
	 * @param typecommande the typecommande to set
	 */
	public void setTypecommande(Typecommande typecommande) {
		this.typecommande = typecommande;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", datedemmande=" + datedemmande + ", ref=" + ref + ", compte=" + compte
				+ ", etatCommande=" + etatCommande + ", typecommande=" + typecommande + "]";
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Long id, Date datedemmande, String ref, Compte compte, EtatCommande etatCommande,
			Typecommande typecommande) {
		super();
		this.id = id;
		this.datedemmande = datedemmande;
		this.ref = ref;
		this.compte = compte;
		this.etatCommande = etatCommande;
		this.typecommande = typecommande;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
