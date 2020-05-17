package com.example.gestionbacaire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.EmployeDao;
import com.example.gestionbacaire.bean.Employe;
import com.example.gestionbacaire.service.facade.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {
	@Autowired
    private EmployeDao employeDao;
	@Override
	public int save(Employe employe) {
		if(findByCin(employe.getCin())==null)
		{
			employeDao.save(employe);
		return 1;}
		return-1;
		}

	@Override
	public Employe findByCin(String cin) {
		// TODO Auto-generated method stub
		return employeDao.findByCin(cin);
	}

}
