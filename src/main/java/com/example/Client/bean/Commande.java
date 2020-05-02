package com.example.Client.bean;

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
public  abstract class Commande  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
	private Date datedemmande;
	private String ref;
	@ManyToOne
	private Client client;
	@ManyToOne
private EtatCommande etatCommande;
	
	
	
	public String getRef() {
		return ref;
	}
	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Long getId() {
		return id;
	}
	/**
	 * @return the datedemmande
	 */
	public Date getDatedemmande() {
		return datedemmande;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param datedemmande the datedemmande to set
	 */
	public void setDatedemmande(Date datedemmande) {
		this.datedemmande = datedemmande;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	/**
	 * @return the etatCommande
	 */
	public EtatCommande getEtatCommande() {
		return etatCommande;
	}
	
	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}
	
	
	public Commande(Long id, Date datedemmande, String ref, Client client, EtatCommande etatCommande) {
		super();
		this.id = id;
		this.datedemmande = datedemmande;
		this.ref = ref;
		this.client = client;
		this.etatCommande = etatCommande;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CommandeCheque [id=" + id + ", datedemmande=" + datedemmande + ", client=" + client + ", nbPage="
				+  "]";
	}
	
	
}
