package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Facture;
import com.example.gestionbacaire.bean.TypeFacture;

@Repository
public interface TypeFactureDao extends JpaRepository<TypeFacture,Long> {
public TypeFacture findByLibelle(String libelle);
}
