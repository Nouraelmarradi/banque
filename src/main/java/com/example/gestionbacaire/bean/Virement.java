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

	public Virement(String ref, Long montant, Date date, Compte comptSource, Compte compteDestinaton) {
		super(ref, montant, date, comptSource, compteDestinaton);
		// TODO Auto-generated constructor stub
	}

	
}
