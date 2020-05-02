package com.example.Client.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class EtatCommande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	private String libelle;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "EtatCommande [id=" + id + ", libelle=" + libelle + "]";
	}
	public EtatCommande(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public EtatCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
