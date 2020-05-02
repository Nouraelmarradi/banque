package com.example.Client.service.facade;


import com.example.Client.bean.Client;

public interface ClientService  {
	public Client findByCin(String cin);
public int save(Client client);
}
