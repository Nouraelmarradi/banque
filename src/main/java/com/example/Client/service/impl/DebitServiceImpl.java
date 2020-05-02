package com.example.Client.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.Dao.CompteDao;
import com.example.Client.Dao.DebitDao;
import com.example.Client.bean.Compte;
import com.example.Client.bean.Debit;
import com.example.Client.bean.Operation;
import com.example.Client.service.facade.CompteService;
import com.example.Client.service.facade.DebitService;
import com.example.Client.service.facade.OparationService;

@Service
public class DebitServiceImpl implements DebitService {
	@Autowired
private DebitDao debitDao;
	@Autowired
	private CompteService compteService;
	@Autowired
	private CompteDao compteDao;
	@Autowired
	private OparationService operationService;
	@Override
	public Debit findByRef(String ref) {
		// TODO Auto-generated method stub
		return debitDao.findByRef(ref);
	}
	
	public int debiter(String rib,double montant) {
	Compte c =compteService.findByRib(rib);
	if(c==null)return -1;
	else if(c.getSolde()<montant) {
		return -2;
	}else {
		c.setSolde(c.getSolde()-montant);
		compteDao.save(c);
		return 1;
	}
	}
	
	    @Override
	    public int save(Debit debit) {
		 Operation d=operationService.findByRef(debit.getRef());
		 Compte c=compteService.findByRib(debit.getComptSource().getRib());

		 if(d!=null)
			return -1;
		 {
			if(c!=null)
			debiter(c.getRib(), debit.getMontant());
		debit.setComptSource(c);
		debit.setMontant(debit.getMontant());
        debit.setDate(new Date());
        compteDao.save(c);
        debitDao.save(debit);
        return 1;}}

}
