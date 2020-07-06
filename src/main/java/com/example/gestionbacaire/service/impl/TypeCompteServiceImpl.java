package com.example.gestionbacaire.service.impl;

import java.util.List;

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
	@Override
	public int save(TypeCompte typeCompte) {
		TypeCompte t=findByLibelle(typeCompte.getLibelle());
		if(t!=null) {return -1;}
		typeCompteDao.save(typeCompte);
		return -1;
	}
	@Override
public List<TypeCompte> findAll(){
return typeCompteDao.findAll();
}
}