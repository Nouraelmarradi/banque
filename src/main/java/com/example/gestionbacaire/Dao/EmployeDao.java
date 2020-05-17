package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Employe;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {
public Employe  findByCin(String cin);

}
