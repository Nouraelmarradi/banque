package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.TypeCompte;

@Repository
public interface TypeCompteDao extends JpaRepository<TypeCompte, Long>{
public TypeCompte findByLibelle(String libelle);
}
