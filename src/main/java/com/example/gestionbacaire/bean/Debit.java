package com.example.gestionbacaire.bean;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Debit")
public class Debit extends Operation {

	public Debit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Debit(Long montant, Date date, Compte comptSource) {
		super(montant, date, comptSource);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
