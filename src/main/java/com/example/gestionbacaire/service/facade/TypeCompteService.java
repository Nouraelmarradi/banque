package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.TypeCompte;

public interface TypeCompteService {
	public TypeCompte findByLibelle(String libelle);

	List<TypeCompte> findAll();

	int save(TypeCompte typeCompte);
}
