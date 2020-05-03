package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.Operation;

public interface OparationService {
	Operation  findByRef(String ref);
	int save(Operation operation);
	public int debiter(String rib,double montant) ;
	List<Operation> findByComptSourceRibOrderByDateDesc(String rib);
int instance(String ref);
public double calculeMensualite(double c,int duree,double taux);
}
