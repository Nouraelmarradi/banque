package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.AgenceDao;
import com.example.gestionbacaire.bean.Agence;
import com.example.gestionbacaire.bean.Banque;
import com.example.gestionbacaire.bean.Directeur;
import com.example.gestionbacaire.service.facade.AgenceService;
import com.example.gestionbacaire.service.facade.BanqueService;
import com.example.gestionbacaire.service.facade.DirecteurService;

@Service
public class AgenceServiceImpl implements AgenceService {
	@Autowired
private AgenceDao agenceDao;
	@Autowired
	private BanqueService banqueService;
	@Autowired
	private DirecteurService directeurService;
	@Override
	public Agence findByNumero(int numero) {
		return agenceDao.findByNumero(numero);
	}

	@Override
	public int save(Agence agence) {
		Agence ag=findByNumero(agence.getNumero());
		Banque banque=banqueService.findByNom(agence.getBanque().getNom());
		Directeur d=directeurService.findByCin(agence.getDirecteur().getCin());
		if(ag!=null)return -1;
		if(banque==null)return -2;
		if(d==null)return -3;
		else {
			agence.setBanque(agence.getBanque());
			agence.setDirecteur(agence.getDirecteur());
		return 0;
	}}

}
