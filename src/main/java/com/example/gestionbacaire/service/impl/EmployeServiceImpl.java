package com.example.gestionbacaire.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.EmployeDao;
import com.example.gestionbacaire.bean.Agence;
import com.example.gestionbacaire.bean.Calulcule;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Employe;
import com.example.gestionbacaire.service.facade.AgenceService;
import com.example.gestionbacaire.service.facade.EmployeService;
import com.example.gestionbacaire.service.utile.PasswordUtils;

@Service
public class EmployeServiceImpl implements EmployeService {
	@Autowired
    private EmployeDao employeDao;
	@Autowired
	private AgenceService agenceService;

	@Override
	public List<Employe>findAll(){
		return employeDao.findAll();
	}
	@Override
	public Employe findByCin(String cin) {
		return employeDao.findByCin(cin);
	}
	@Override
public int save(Employe employe) {
Employe o=findByCin(employe.getCin());	
Agence agence=agenceService.findByNumero(employe.getAgence().getNumero());
if(o!=null) {
	return -1;
}
else {
		if(agence==null) {
			return -2;
		}
		 // Generate Salt. The generated value can be stored in DB. 
		String salt = PasswordUtils.getSalt(30);


		// Protect user's password. The generated value can be stored in DB.
		String mySecurePassword = PasswordUtils.generateSecurePassword(employe.getPassworld(), salt);

		// Print out protected password 
		System.out.println("My secure password = " + mySecurePassword);
		System.out.println("Salt value = " + salt);
		employe.setAgence(agence);
		
		

	employe.setAgence(agence);
	employe.setSalet(salt);
	employe.setPassworld(mySecurePassword);

	employeDao.save(employe);
	
	return 1;
}}

   @Override
	public int Update(Employe employe) {
		Employe em=employeDao.findById(employe.getId()).get();
		if(em==null) {
			return -1;
		}
		employeDao.save(em);
		return 1;
	}
@Transactional
@Override
public int delete(String cin) {
	Employe em= findByCin(cin);
	if(em==null) {
		return -1;
	}else {
		employeDao.delete(em);;
		return 1;
	}
}
@Override	
public int 	login(String username,String passwed) {
	  Employe ct=findByUsername(username);
	  if(ct==null) {
		  return -1;
	  }
      boolean passwordMatch = PasswordUtils.verifyUserPassword(passwed,ct.getPassworld() ,ct.getSalet());
      
      if(passwordMatch) 
      {
    	  
   
return 1;
      } else {
        return   -2;
      }
  }
@Override
public Employe findByUsername(String username) {
	// TODO Auto-generated method stub
	return employeDao.findByUsername(username);
}
@Override
public List<Employe> findByAgencenumero(Long num) {
	// TODO Auto-generated method stub
	return employeDao.findByAgenceNumero(num);
}
@Override
public Employe findByUserUsername(String username) {
	// TODO Auto-generated method stub
	return employeDao.findByUserUsername(username);
}


}
