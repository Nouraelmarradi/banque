package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Client;
@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
public Client findByCin(String cin);
}
