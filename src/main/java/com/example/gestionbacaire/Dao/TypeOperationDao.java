package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionbacaire.bean.TypeOperation;

public interface TypeOperationDao extends JpaRepository<TypeOperation, Long> {
public TypeOperation findByLibelle(String libelle);
}
