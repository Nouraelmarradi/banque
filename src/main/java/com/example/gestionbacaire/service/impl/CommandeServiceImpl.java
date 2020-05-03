package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CommandeDao;
import com.example.gestionbacaire.bean.Commande;
import com.example.gestionbacaire.service.facade.CommandeService;

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
