package com.example.gestionbacaire.service.facade;


import com.example.gestionbacaire.bean.Client;

public interface ClientService  {
	public Client findByCin(String cin);
public int save(Client client);
}
