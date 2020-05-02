package com.example.Client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.Directeurdao;
import com.example.Client.bean.Directeur;
import com.example.Client.service.facade.DirecteurService;

@Service
public class DirecteurServiceImpl implements DirecteurService {
	@Autowired
private Directeurdao  directeurdao;
	@Override
	public Directeur findByCin(String cin) {
		// TODO Auto-generated method stub
		return directeurdao.findByCin(cin);
	}

	@Override
	public int save(Directeur directeur) {
		if(findByCin(directeur.getCin())!=null)
			return -1;
		else {
			directeurdao.save(directeur);
		return 1;
	}}

}
