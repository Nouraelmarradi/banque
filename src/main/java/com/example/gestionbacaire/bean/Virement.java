package com.example.gestionbacaire.bean;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "V")
public class Virement extends Operation {

	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Virement(Long montant, Date date, Compte comptSource) {
		super(montant, date, comptSource);
		// TODO Auto-generated constructor stub
	}

	
}
