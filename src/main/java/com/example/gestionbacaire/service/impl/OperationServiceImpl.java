package com.example.gestionbacaire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.Dao.OperationDao;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Debit;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.bean.TypeOperation;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.OparationService;
import com.example.gestionbacaire.service.facade.TypeOperationService;

@Service
public class OperationServiceImpl implements OparationService{
	@Autowired
	private OperationDao operationdao;
		@Autowired
	private CompteService compteService;
		@Autowired
		private TypeOperationService typeOperationService;
	@Autowired	
	private CompteDao compteDao;	
		@Override
		public int save(Operation operation) {
			Compte cr=null;
			Operation o=findByRef(operation.getRef());
			Compte c=compteService.findByRib(operation.getComptSource().getRib());
			if(o!=null) 
			return -1;
			else {
			
			if(c==null)
				return -3;
			else if(cr==null)
				return -4;
			else{
				{transfer(c.getRib(),cr.getRib(),operation.getMontant());
			operation.setComptSource(c);
			operation.setMontant(operation.getMontant());
	operation.setDate(new Date());
	compteDao.save(c);
	compteDao.save(cr);
			operationdao.save(operation);
			return 1;}
					
			}
			}}
			
	@Override
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
			return operationdao.findByRef(ref);
		}

		
		@Override
		public List<Operation> findByComptSourceRibOrderByDateDesc(String rib) {
			// TODO Auto-generated method stub
			return operationdao.findByComptSourceRibOrderByDateDesc(rib);
		}

		@Override
		public int instance(String ref) {
			// TODO Auto-generated method stub
			Operation o=findByRef(ref);
			if(o instanceof Debit)
			return 1;
			else return 2;
		}

		@Override
		public double calculeMensualite(double c, int duree, double taux) {
			double t=taux/100;
			double t1=c*t/12;
			double t2=Math.pow(1+t/12,-1*duree);
			double t3=1-t2;
			return t1/t3;
		}

		

}
