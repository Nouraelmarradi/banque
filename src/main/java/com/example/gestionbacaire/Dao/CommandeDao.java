package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
public Commande findByRef(String ref);
}
