package com.example.Client.service.facade;

import com.example.Client.bean.Agence;

public interface AgenceService {
	Agence findByNumero(int numero);
	int save(Agence agence);
}
