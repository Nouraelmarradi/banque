package com.example.gestionbacaire.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.ClientDao;
import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.bean.Agence;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.service.facade.AgenceService;
import com.example.gestionbacaire.service.facade.ClientService;
import com.example.gestionbacaire.service.facade.CompteService;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
private ClientDao clientDao;
	@Autowired
private CompteDao compteDao;
	@Autowired
private CompteService compteService;
	@Autowired
private AgenceService agenceService;

	@Override
	public Client findByCin(String cin) {
		// TODO Auto-generated method stub
		return clientDao.findByCin(cin);
	}

	@Override
	public int save(Client client) {
		Client c=findByCin(client.getCin());
		Agence agence=agenceService.findByNumero(client.getAgence().getNumero());
		if(c!=null)
			return -1;
		if(agence==null)
			return -2;
		else {
			client.setAgence(agence);
			clientDao.save(client)	;
		}
		return 1;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientDao.findAll();
	}
   @Transactional
	@Override
	public int deleteByCin(String cin) {
	int res2=compteService.deleteAll(cin);
	int res1=clientDao.deleteByCin(cin);
		return res1*res2;
	}
}
