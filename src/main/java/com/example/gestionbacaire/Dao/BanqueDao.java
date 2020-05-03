package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Banque;

@Repository
public interface BanqueDao extends JpaRepository<Banque, Long>{
Banque findByNom(String nom);

}
