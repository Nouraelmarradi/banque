package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.ClientDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.service.facade.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
private ClientDao clientDao;
	@Override
	public Client findByCin(String cin) {
		// TODO Auto-generated method stub
		return clientDao.findByCin(cin);
	}

	@Override
	public int save(Client client) {
		Client c=findByCin(client.getCin());
		if(c!=null)
			return -1;
		else {
			clientDao.save(client)	;
		}
		return 1;
	}
	
}
