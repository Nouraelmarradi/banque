package com.example.Client.service.facade;

import com.example.Client.bean.Directeur;

public interface DirecteurService {
	public Directeur findByCin(String cin); 
public int save(Directeur directeur);
}
