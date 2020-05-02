package com.example.Client.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.Courant;

@Repository
public interface CourantDao extends JpaRepository<Courant,Long> {

}
