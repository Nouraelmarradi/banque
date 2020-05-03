package com.example.gestionbacaire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.TypeOperationDao;
import com.example.gestionbacaire.bean.TypeOperation;
import com.example.gestionbacaire.service.facade.TypeOperationService;

@Service
public class TypeOperationServiceImpl implements TypeOperationService {
	@Autowired
private TypeOperationDao typeOpertionDao;
	@Override
	public TypeOperation findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return typeOpertionDao.findByLibelle(libelle);
	}

	@Override
	public int save(TypeOperation typeOperation) {
		TypeOperation tp=findByLibelle(typeOperation.getLibelle());
		if(tp!=null)
		return -1;
		else {
			typeOpertionDao.save(typeOperation);
			return 1;}
	}

	@Override
	public List<TypeOperation> findAll() {
		// TODO Auto-generated method stub
		return typeOpertionDao.findAll();
	}

}
