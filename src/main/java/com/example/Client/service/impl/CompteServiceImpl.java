package com.example.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.CompteDao;
import com.example.Client.bean.Client;
import com.example.Client.bean.Compte;
import com.example.Client.bean.TypeCompte;
import com.example.Client.service.facade.ClientService;
import com.example.Client.service.facade.CompteService;
import com.example.Client.service.facade.TypeCompteService;

@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
private CompteDao compteDao;
	@Autowired
	private ClientService clientService;
	@Autowired
	private TypeCompteService typeCompteService;
	@Override
	public Compte findByRib(String rib) {
		// TODO Auto-generated method stub
		return compteDao.findByRib(rib);
	}
	
	@Override
	public int save(Compte compte) {
		Compte c =findByRib(compte.getRib());
		Client client=clientService.findByCin(compte.getClient().getCin());
		TypeCompte typeCompte=typeCompteService.findByLibelle(compte.getTypeCompte().getLibelle());
		if(c!=null)
			return -1;
		if(client==null)return -2;
		if(typeCompte==null)return -3;
		else {
			compte.setClient(client);
			compte.setEmploye(null);
			compte.setDevise(null);
			compte.setTypeCompte(typeCompte);
			compteDao.save(compte);
			return 1;
		}
	}

}
