package com.example.gestionbacaire.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {
public Employe findByCin(String cin);
public Employe findByUsername(String username);
public List<Employe>findByAgenceNumero(Long num);
public Employe findByUserUsername(String username);
}
