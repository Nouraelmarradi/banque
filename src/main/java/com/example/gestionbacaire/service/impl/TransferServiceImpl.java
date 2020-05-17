package com.example.gestionbacaire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.Dao.TranseferDao;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Debit;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.bean.Transfer;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.DebitService;
import com.example.gestionbacaire.service.facade.OparationService;
import com.example.gestionbacaire.service.facade.TransferService;
import com.example.gestionbacaire.service.facade.TypeOperationService;

@Service
public class TransferServiceImpl implements TransferService{
	@Autowired
	private TranseferDao transferDao;
		@Autowired
	private CompteService compteService;
		
		@Autowired
		private OparationService oparationService;
		
	@Autowired	
	private CompteDao compteDao;	
		@Override
		public int save(Transfer transfer) {
			Operation o=findByRef(transfer.getLibelle());
			Operation d=	 oparationService.findByRef(transfer.getLibelle());
			Compte c=compteService.findByRib(transfer.getComptSource().getRib());
			Compte cr=compteService.findByRib(transfer.getCompteDes().getRib());
			if(o!=null) 
			return -1;
			if(d!=null) 
				return -2;
			else {
			
			if(c==null)
				return -3;
			else if(cr==null)
				return -4;
			else{
				transfer(c.getRib(),cr.getRib(),transfer.getMontant());
				transfer.setComptSource(c);
				transfer.setCompteDes(cr);
				transfer.setMontant(transfer.getMontant());
				transfer.setDate(new Date());
	compteDao.save(c);
	compteDao.save(cr);
	transferDao.save(transfer);
	System.out.println(transfer.getClass().getSimpleName());
			return 1;
			}
					
			}
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
		
		public int crediter(String rib,double montant) {
			Compte c =compteService.findByRib(rib);
			if(c==null)return -1;
				c.setSolde(c.getSolde()+montant);
				compteDao.save(c);
				return 1;
			}	
		
		public int transfer(String ribsource,String ribdestination,double montant) {
			Compte c =compteService.findByRib(ribsource);
			Compte c1 =compteService.findByRib(ribdestination);
			if(c==null)return -1;
			else if (c1==null) return -2;
			else {
				crediter(c1.getRib(),montant);
				debiter(c.getRib(), montant);
				return 1;
			}
			
		}
		@Override
		public Operation findByRef(String ref) {
			// TODO Auto-generated method stub
			return transferDao.findByRef(ref);
		}
		

		@Override
		public List<Operation> findByComptSourceRibOrderByDateDesc(String rib) {
			// TODO Auto-generated method stub
			return transferDao.findByComptSourceRibOrderByDateDesc(rib);
		}


}
