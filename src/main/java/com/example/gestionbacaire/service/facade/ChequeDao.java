package com.example.gestionbacaire.service.facade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionbacaire.bean.CommandeCheque;

@Repository
public interface ChequeDao extends JpaRepository<CommandeCheque, Long> {

}
