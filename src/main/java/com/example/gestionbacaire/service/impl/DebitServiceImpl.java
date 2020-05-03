package com.example.gestionbacaire.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.Dao.DebitDao;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Debit;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.DebitService;
import com.example.gestionbacaire.service.facade.OparationService;

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
