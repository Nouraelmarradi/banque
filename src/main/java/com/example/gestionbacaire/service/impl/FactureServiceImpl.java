package com.example.gestionbacaire.service.impl;

import org.springframework.stereotype.Service;

import com.example.gestionbacaire.bean.Facture;
import com.example.gestionbacaire.service.facade.FactureService;

@Service
public class FactureServiceImpl implements FactureService {

	@Override
	public Facture findByCompteRibOrderByDateFactureDesc(String rib) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture findByTypeFactureLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Facture facture) {
		// TODO Auto-generated method stub
		return 0;
	}

}
