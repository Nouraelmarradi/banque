package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.TypeCompte;

public interface TypeCompteService {
	public TypeCompte findByLibelle(String libelle);
}
