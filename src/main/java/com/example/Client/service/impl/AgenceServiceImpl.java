package com.example.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.AgenceDao;
import com.example.Client.bean.Agence;
import com.example.Client.bean.Banque;
import com.example.Client.bean.Directeur;
import com.example.Client.service.facade.AgenceService;
import com.example.Client.service.facade.BanqueService;
import com.example.Client.service.facade.DirecteurService;

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
