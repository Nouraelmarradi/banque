package com.example.gestionbacaire.ws.converter.vo;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.TypeFacture;

public class ProduitVo {
	private Long id;
    private String reference;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
    
		
}
