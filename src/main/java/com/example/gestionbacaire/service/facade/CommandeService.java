package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Commande;

  public interface CommandeService {
	public Commande CommandefindByRef(String ref);
}
