package com.example.gestionbacaire.bean;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("transfer")
public class Transfer extends Operation {
	@ManyToOne
private Compte compteDes;

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Transfer(Long montant, Date date, Compte comptSource) {
		super(montant, date, comptSource);
		// TODO Auto-generated constructor stub
	}



	public Transfer(Compte compteDes) {
		super();
		this.compteDes = compteDes;
	}

	public Compte getCompteDes() {
		return compteDes;
	}

	/**
	 * @param compteDes the compteDes to set
	 */
	public void setCompteDes(Compte compteDes) {
		this.compteDes = compteDes;
	}
	
}
