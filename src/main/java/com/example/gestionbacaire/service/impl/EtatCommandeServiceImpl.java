package com.example.gestionbacaire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.EtatCommandeDao;
import com.example.gestionbacaire.bean.EtatCommande;
import com.example.gestionbacaire.service.facade.EtatCommandeService;
@Service
public class EtatCommandeServiceImpl implements EtatCommandeService {
	@Autowired
private EtatCommandeDao etatCommandeDao;
	@Override
	public EtatCommande findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return etatCommandeDao.findByLibelle(libelle) ;
	}

	@Override
	public List<EtatCommande> findAll() {
		// TODO Auto-generated method stub
		return etatCommandeDao.findAll();
	}

	@Override
	public int save(EtatCommande etatCommande) {
		if((findByLibelle(etatCommande.getLibelle())==null)) {
			etatCommandeDao.save(etatCommande)	;
		 return 1;}
		else {
		return -1;	 
		}
	}

}
