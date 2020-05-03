package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.service.facade.ClientService;
import com.example.gestionbacaire.service.facade.CompteService;

@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
private CompteDao compteDao;
	@Autowired
	private ClientService clientService;
	
	@Override
	public Compte findByRib(String rib) {
		// TODO Auto-generated method stub
		return compteDao.findByRib(rib);
	}
	
	@Override
	public int save(Compte compte) {
		Compte c =findByRib(compte.getRib());
		Client client=clientService.findByCin(compte.getClient().getCin());
		//TypeCompte typeCompte=typeCompteService.findByLibelle(compte.getTypeCompte().getLibelle());
		if(c!=null)
			return -1;
		if(client==null)return -2;
		else {
			compte.setClient(client);
			compte.setEmploye(null);
			compte.setDevise(null);
			compteDao.save(compte);
			return 1;
		}
	}

}
