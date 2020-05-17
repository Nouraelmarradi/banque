package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Typecommande;

@Repository
public interface TypeCommandeDao extends JpaRepository<Typecommande, Long> {
	public Typecommande findByLibelle(String libelle);

}
