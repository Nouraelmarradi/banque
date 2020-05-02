package com.example.Client.service.facade;

import com.example.Client.bean.Compte;

public interface CompteService {
	public Compte findByRib(String rib);
	public int save(Compte compte);
}
