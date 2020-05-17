package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Facture;

public interface FactureService {
	public Facture findByCompteRibOrderByDateFactureDesc(String rib);
	public Facture findByTypeFactureLibelle(String libelle);
	public int save(Facture facture);

}
