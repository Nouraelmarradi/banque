package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Facture;

@Repository
public  interface FactureDao extends JpaRepository<Facture, Long>{
public Facture findByCompteRibOrderByDateFactureDesc(String rib);
public Facture findByTypeFactureLibelle(String libelle);
public Facture findByCompteClientCin(String cin);

}
