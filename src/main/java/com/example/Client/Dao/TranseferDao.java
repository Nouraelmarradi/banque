package com.example.Client.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Client.bean.Operation;
import com.example.Client.bean.Transfer;

public interface TranseferDao extends JpaRepository<Transfer, Long>{
Operation   findByRef(String ref);
//@Query("select o from Operation order by o.montant")
List<Operation> findByComptSourceRibOrderByDateDesc(String rib);
}
