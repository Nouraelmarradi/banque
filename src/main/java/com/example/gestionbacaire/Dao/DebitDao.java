package com.example.gestionbacaire.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Debit;
import com.example.gestionbacaire.bean.Operation;

@Repository
public interface DebitDao extends JpaRepository<Debit,Long> {
	public Debit findByRef(String ref);
}
