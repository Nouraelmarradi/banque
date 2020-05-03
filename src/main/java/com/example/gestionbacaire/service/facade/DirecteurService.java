package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Directeur;

public interface DirecteurService {
	public Directeur findByCin(String cin); 
public int save(Directeur directeur);
}
