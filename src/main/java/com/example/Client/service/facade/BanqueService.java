package com.example.Client.service.facade;

import com.example.Client.bean.Banque;

public interface BanqueService {
int save(Banque banque); 
Banque findByNom(String nom);
}
