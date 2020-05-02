package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.Client;
@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
public Client findByCin(String cin);
}
