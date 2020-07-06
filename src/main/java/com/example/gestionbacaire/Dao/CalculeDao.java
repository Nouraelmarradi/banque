package com.example.gestionbacaire.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Calulcule;

@Repository
public interface CalculeDao extends JpaRepository<Calulcule, Long> {
public Calulcule findByMois(int mois);
public List<Calulcule> findByAnne(int mois);

}
