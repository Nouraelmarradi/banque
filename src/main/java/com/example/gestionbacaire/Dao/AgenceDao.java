package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionbacaire.bean.Agence;

public interface AgenceDao extends JpaRepository<Agence, Long> {
  public Agence findByNumero(Long numero);
}
 