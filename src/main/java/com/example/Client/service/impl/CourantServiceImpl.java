package com.example.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.CourantDao;
import com.example.Client.bean.Courant;
import com.example.Client.service.facade.CompteService;
import com.example.Client.service.facade.CourantService;

@Service
public class CourantServiceImpl implements CourantService{
	@Autowired
private CourantDao courantDao;
	@Autowired
	private CompteService compteService;
	@Override
	public int save(Courant courant) {
		// TODO Auto-generated method stub
		courant.setNb(courant.getNb());
		System.out.println(compteService.save(courant));
		 compteService.save(courant);
		 return 1;
	}

}
