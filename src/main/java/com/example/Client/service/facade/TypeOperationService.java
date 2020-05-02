package com.example.Client.service.facade;

import java.util.List;

import com.example.Client.bean.TypeOperation;

public interface TypeOperationService {
	public TypeOperation findByLibelle(String libelle);
	public int save(TypeOperation typeOperation);
	public List<TypeOperation>findAll();

}
