package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.Employe;

public interface EmployeService {
	public List<Employe> findAll();
	Employe findByCin(String cin);
	int save(Employe employe);
	int Update(Employe employe);
	public Employe findByUsername(String username);
	public List<Employe>findByAgencenumero(Long num);
	int delete(String cin);
	int login(String username, String passwed);
	public Employe findByUserUsername(String username);

}
