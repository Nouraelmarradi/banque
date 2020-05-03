package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Banque;

public interface BanqueService {
int save(Banque banque); 
Banque findByNom(String nom);
}
