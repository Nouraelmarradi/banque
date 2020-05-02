package com.example.Client.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeFacture {
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
	public TypeFacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeFacture(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "TypeFacture [id=" + id + ", libelle=" + libelle + "]";
	}
	
}
