package com.example.Client.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.Operation;
@Repository
public interface OperationDao extends JpaRepository<Operation, Long>{
Operation  findByRef(String ref);
List<Operation> findAllByOrderByDateDesc();
List<Operation> findByComptSourceRibOrderByDateDesc(String rib);
}
