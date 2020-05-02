package com.example.Client.service.facade;

import java.util.List;

import com.example.Client.bean.TypeCompte;

public interface TypeCompteService {
	public TypeCompte findByLibelle(String libelle);
	public int save(TypeCompte typecompte);
public List<TypeCompte>findAll();
}
