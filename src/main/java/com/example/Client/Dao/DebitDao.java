package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.Debit;
import com.example.Client.bean.Operation;

@Repository
public interface DebitDao extends JpaRepository<Debit,Long> {
	public Debit findByRef(String ref);
}
