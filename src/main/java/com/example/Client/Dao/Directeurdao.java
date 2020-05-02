package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.Directeur;
@Repository
public interface Directeurdao extends JpaRepository<Directeur, Long>{
public Directeur findByCin(String cin); 

}
