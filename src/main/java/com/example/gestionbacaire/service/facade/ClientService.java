package com.example.gestionbacaire.service.facade;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.example.gestionbacaire.bean.Client;

public interface ClientService  {
	public Client findByCin(String cin);
public int save(Client client);
public List<Client>findAll();
public int deleteByCin(String cin);
}
