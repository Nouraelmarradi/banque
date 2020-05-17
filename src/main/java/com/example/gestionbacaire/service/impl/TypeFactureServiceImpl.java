package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.TypeFactureDao;
import com.example.gestionbacaire.bean.TypeFacture;
import com.example.gestionbacaire.service.facade.TypeFactureService;

@Service
public class TypeFactureServiceImpl implements TypeFactureService{
	@Autowired
private TypeFactureDao typeFactureDao; 
	@Override
	public TypeFacture findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return typeFactureDao.findByLibelle(libelle);
	}
	@Override
	public int save(TypeFacture typeFacture) {
	TypeFacture c=	findByLibelle(typeFacture.getLibelle());
		if(c!=null)return -1;
		else {
			typeFactureDao.save(typeFacture);
			return 1;
		}
	}

}
