package com.example.Client.service.facade;

import java.util.List;

import com.example.Client.bean.EtatCommande;

public interface EtatCommandeService {
	public EtatCommande  findByLibelle(String libelle);
public List<EtatCommande>findAll();
public int save(EtatCommande etatCommande);
}
