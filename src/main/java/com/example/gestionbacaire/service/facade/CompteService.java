package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.Compte;

public interface CompteService {
	public Compte findByRib(String rib);
	public int save(Compte compte);
	public int deleteByRib(String rib);
	public List<Compte> findByClientCin(String cin);
	public int deleteAll(String cin);
	int updateCompte(Compte c);
	List<Compte> findAll();
	List<Compte> findByClientUsername(String Username);
	List<Compte> findAllbyRech(String rib);
	
}
