package com.example.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.CourantDao;
import com.example.Client.bean.Courant;
import com.example.Client.bean.Epargne;
import com.example.Client.service.facade.CompteService;
import com.example.Client.service.facade.CourantService;
import com.example.Client.service.facade.EpargneService;

@Service
public class EpargneServiceImpl implements EpargneService{
	@Autowired
private CourantDao courantDao;
	@Autowired
	private CompteService compteService;
	@Override
	public int save(Epargne courant) {
		// TODO Auto-generated method stub
		courant.setTaux(courant.getTaux());
		System.out.println(compteService.save(courant));
		 compteService.save(courant);
		 return 1;
	}

}
