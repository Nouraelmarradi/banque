package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Commande;

  public interface CommandeService {
	public Commande findByRef(String ref);
	public int modifieEtat(String etat,String ref);
	 public int save(Commande c);
}
