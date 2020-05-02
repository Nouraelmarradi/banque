package com.example.Client.service.facade;

import java.util.List;

import com.example.Client.bean.Operation;

public interface OparationService {
	Operation  findByRef(String ref);
	int save(Operation operation);
	public int debiter(String rib,double montant) ;
	List<Operation> findAllByComptSourceRib(String rib);
	List<Operation> findAllByOrderByDateDesc();
int instance(String ref);
public double calculeMensualite(double c,int duree,double taux);
}
