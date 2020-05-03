package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.Debit;
import com.example.gestionbacaire.bean.Operation;

public interface DebitService {
	public Debit findByRef(String ref);
	public int save(Debit debit);
}
