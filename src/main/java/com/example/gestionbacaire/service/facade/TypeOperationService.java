package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.TypeOperation;

public interface TypeOperationService {
	public TypeOperation findByLibelle(String libelle);
	public int save(TypeOperation typeOperation);
	public List<TypeOperation>findAll();

}
