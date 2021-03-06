package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.EtatCommande;
@Repository
public interface EtatCommandeDao extends JpaRepository<EtatCommande, Long> {
public EtatCommande  findByLibelle(String libelle);

}
