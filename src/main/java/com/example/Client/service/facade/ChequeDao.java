package com.example.Client.service.facade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Client.bean.CommandeCheque;

@Repository
public interface ChequeDao extends JpaRepository<CommandeCheque, Long> {

}
