package com.example.gestionbacaire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.AgenceDao;
import com.example.gestionbacaire.bean.Agence;
import com.example.gestionbacaire.bean.Banque;
import com.example.gestionbacaire.bean.Directeur;
import com.example.gestionbacaire.bean.Employe;
import com.example.gestionbacaire.service.facade.AgenceService;
import com.example.gestionbacaire.service.facade.BanqueService;
import com.example.gestionbacaire.service.facade.DirecteurService;
import com.example.gestionbacaire.service.facade.EmployeService;

@Service
public class AgenceServiceImpl implements AgenceService {
	@Autowired
private AgenceDao agenceDao;
	@Autowired
	private BanqueService banqueService;
	@Autowired
	private EmployeService employeService;
	@Override
	public Agence findByNumero(Long numero) {
		return agenceDao.findByNumero(numero);
	}
	@Override
	public List<Agence>findAll(){
		return agenceDao.findAll();
	}

	@Override
	public int save(Agence agence) {
		Agence ag=findByNumero(agence.getNumero());
		Employe d=employeService.findByCin(agence.getDirecteure());
		if(ag!=null)return -1;
		
		else {
			if(d==null)return -3;
			agence.setBanque(agence.getBanque());
			agence.setDirecteure(agence.getDirecteure());
			agence.setDateCreation(new Date());;
			agence.setAdress(agence.getAdress());
			agenceDao.save(agence);
		return 1;
	}}

}
