package com.example.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.CommandeDao;
import com.example.Client.bean.Commande;
import com.example.Client.service.facade.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{
	@Autowired
private CommandeDao commandeDao;

	@Override
	public Commande CommandefindByRef(String ref) {
		// TODO Auto-generated method stub
		return commandeDao.findByRef(ref);
	}
	

}
