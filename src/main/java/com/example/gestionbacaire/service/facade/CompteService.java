package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Compte;

public interface CompteService {
	public Compte findByRib(String rib);
	public int save(Compte compte);
}