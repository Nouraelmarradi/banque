package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Courant;

@Repository
public interface CourantDao extends JpaRepository<Courant,Long> {

}
