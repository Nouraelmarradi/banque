package com.example.Client.service.facade;

import java.util.List;

import com.example.Client.bean.Operation;
import com.example.Client.bean.Transfer;

public interface TransferService {
	Operation  findByRef(String ref);
	int save(Transfer transfer);
	List<Operation> findByComptSourceRibOrderByDateDesc(String rib);

}
