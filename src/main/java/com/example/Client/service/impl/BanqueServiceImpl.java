package com.example.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.BanqueDao;
import com.example.Client.bean.Banque;
import com.example.Client.service.facade.BanqueService;

@Service
public class BanqueServiceImpl implements BanqueService {
	@Autowired
private BanqueDao banqueDao;
	@Override
	public int save(Banque banque) {
		if(findByNom(banque.getNom())!=null)
		return -1;
		 banqueDao.save(banque);
		 return 1;
	}
	@Override
	public Banque findByNom(String nom) {
		// TODO Auto-generated method stub
		return banqueDao.findByNom(nom);
	}

}
