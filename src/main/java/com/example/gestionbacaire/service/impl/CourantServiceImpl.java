package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CourantDao;
import com.example.gestionbacaire.bean.Courant;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.CourantService;

@Service
public class CourantServiceImpl implements CourantService{
	@Autowired
private CourantDao courantDao;
	@Autowired
	private CompteService compteService;
	@Override
	public int save(Courant courant) {
		// TODO Auto-generated method stub
		courant.setDecouvert(courant.getDecouvert());
		System.out.println(compteService.save(courant));
		 compteService.save(courant);
		 return 1;
	}

}
