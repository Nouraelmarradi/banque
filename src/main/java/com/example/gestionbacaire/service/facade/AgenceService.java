package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.Agence;

public interface AgenceService {
	Agence findByNumero(Long long1);
	int save(Agence agence);
	List<Agence> findAll();
}
