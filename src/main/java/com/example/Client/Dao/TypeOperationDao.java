package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Client.bean.TypeOperation;

public interface TypeOperationDao extends JpaRepository<TypeOperation, Long> {
public TypeOperation findByLibelle(String libelle);
}
