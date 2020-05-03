package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Agence;

public interface AgenceService {
	Agence findByNumero(int numero);
	int save(Agence agence);
}
