package com.example.gestionbacaire.service.facade;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;

public interface ClientService  {
	public Client findByCin(String cin);
public int save(Client client);
public List<Client>findAll();
public int deleteByCin(String cin);
Client findByUsername(String username);
Client findByUserUsername(String username);
int login(String username, String passwed);
int verifier(String pass, Client ct);
int verigfy(Compte c);
int registre(Client client);
int uppdate(Client client);
int savev2(Client client);
int like();
int dselike();
int demmande(Compte c);
int verigy(Compte c);
}
