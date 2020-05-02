package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, Long> {
public Compte findByRib(String rib);
}
