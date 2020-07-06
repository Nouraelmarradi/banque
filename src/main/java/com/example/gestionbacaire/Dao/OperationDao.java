package com.example.gestionbacaire.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Operation;
@Repository
public interface OperationDao extends  PagingAndSortingRepository<Operation, Long> ,JpaRepository<Operation, Long>{
Operation  findByLibelle(String ref);
List<Operation> findAllByOrderByDateDesc();
List<Operation> findByComptSourceRib(String rib);
Page<Operation> findByComptSourceRibOrderByDateDesc(String rib,Pageable p);
int deleteByComptSourceRib(String rib);
int deleteByComptDis(String rib);
List<Operation> findByComptSourceRibOrderByDateAsc(String rib);
@Query("SELECT u FROM Operation u WHERE u.comptSource.rib = :name ORDER BY u.date Desc")
List<Operation>doit(@Param("name") String name);
}
