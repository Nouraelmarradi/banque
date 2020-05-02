package com.example.Client.service.facade;

import com.example.Client.bean.Debit;
import com.example.Client.bean.Operation;

public interface DebitService {
	public Debit findByRef(String ref);
	public int save(Debit debit);
}
