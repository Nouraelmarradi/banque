package com.example.gestionbacaire.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, Long> ,PagingAndSortingRepository<Compte, Long>{
public Compte findByRib(String rib);
public List<Compte> findByClientCin(String cin); 
public int deleteByRib(String rib);
List<Compte> findByClientUsername(String Username) ;
Compte findByClientUserUsername(String Username) ;

}
