package com.example.gestionbacaire.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
public Commande findByRef(String ref);
public List<Commande>findByClientCin(String cin);
}
