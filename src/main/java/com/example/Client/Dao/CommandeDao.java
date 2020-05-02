package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
public Commande findByRef(String ref);
}
