
package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.Commande;

  public interface CommandeService {
	public Commande findByRef(String ref);
	public int modifieEtat(String etat,Commande c);
	 public int save(Commande c);
	 public List<Commande>findAll();
	 public String findByCompteRib(String rib);
	List<Commande> fininitaile();
	List<Commande> finsrehete();
	List<Commande> finaccepte();}
