package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Directeur;
@Repository
public interface Directeurdao extends JpaRepository<Directeur, Long>{
public Directeur findByCin(String cin); 

}
