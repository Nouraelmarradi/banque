package com.example.Client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.TypeCompteDao;
import com.example.Client.bean.TypeCompte;
import com.example.Client.service.facade.TypeCompteService;

@Service
public class TypeCompteServiceImpl implements TypeCompteService{
@Autowired
	private TypeCompteDao typeCompteDao;
	@Override
	public TypeCompte findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return typeCompteDao.findByLibelle(libelle);
	}

	@Override
	public int save(TypeCompte typecompte) {
		TypeCompte tp=findByLibelle(typecompte.getLibelle());
		if(tp!=null)
		return -1;
		else {
			typeCompteDao.save(typecompte);
			return 1;
		}
	}

	@Override
	public List<TypeCompte> findAll() {
		// TODO Auto-generated method stub
		return typeCompteDao.findAll();
	}

}
