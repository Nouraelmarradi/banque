package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CourantDao;
import com.example.gestionbacaire.bean.Courant;
import com.example.gestionbacaire.bean.Epargne;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.CourantService;
import com.example.gestionbacaire.service.facade.EpargneService;

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
