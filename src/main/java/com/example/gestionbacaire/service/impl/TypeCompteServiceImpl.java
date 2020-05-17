package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.TypeCompteDao;
import com.example.gestionbacaire.bean.TypeCompte;
import com.example.gestionbacaire.service.facade.TypeCompteService;

@Service
public class TypeCompteServiceImpl implements TypeCompteService {
	@Autowired
private TypeCompteDao typeCompteDao;
	@Override
	public TypeCompte findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return typeCompteDao.findByLibelle(libelle);
	}

}
