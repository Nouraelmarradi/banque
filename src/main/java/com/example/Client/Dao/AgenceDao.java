package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Client.bean.Agence;

public interface AgenceDao extends JpaRepository<Agence, Long> {
  public Agence findByNumero(int numero);
}
