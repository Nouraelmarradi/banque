package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.bean.Transfer;

public interface TransferService {
	Operation  findByRef(String ref);
	int save(Transfer transfer);
	List<Operation> findByComptSourceRibOrderByDateDesc(String rib);

}
