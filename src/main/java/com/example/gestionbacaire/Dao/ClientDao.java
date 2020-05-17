package com.example.gestionbacaire.Dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.Client;
@Repository
public interface ClientDao extends PagingAndSortingRepository<Client, Long> ,JpaRepository<Client, Long> {
public Client findByCin(String cin);
public int deleteByCin(String cin);
}
