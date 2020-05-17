package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Employe;

public interface EmployeService {
	public int save(Employe employe);
	public Employe  findByCin(String cin);

}
