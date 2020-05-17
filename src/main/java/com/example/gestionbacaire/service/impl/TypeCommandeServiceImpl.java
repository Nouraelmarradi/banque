package com.example.gestionbacaire.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.TypeCommandeDao;
import com.example.gestionbacaire.bean.Typecommande;
import com.example.gestionbacaire.service.facade.TypeCommandeService;

@Service
public class TypeCommandeServiceImpl implements TypeCommandeService{
@Autowired	
private TypeCommandeDao typeCommandeDao;

@Override
public Typecommande findByLibelle(String libelle) {
	// TODO Auto-generated method stub
	return typeCommandeDao.findByLibelle(libelle);
}
}
