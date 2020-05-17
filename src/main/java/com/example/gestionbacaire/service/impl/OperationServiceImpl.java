package com.example.gestionbacaire.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.Dao.OperationDao;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Debit;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.bean.Transfer;
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
			if(operation.getTypeOperation().getLibelle().equals("debit")) {
				operation.setTypeOperation(operation.getTypeOperation());	
		debiter(operation.getComptSource().getRib(), operation.getMontant());
		return 1;}
		else if(operation.getTypeOperation().getLibelle().equals("versement"))
		{			operation.setTypeOperation(operation.getTypeOperation());
transfer(operation.getComptSource().getRib(), operation.getComptDis().getRib(), operation.getMontant());
			
			return 2;
		}	
		else if(operation.getTypeOperation().getLibelle().equals("credit"))	{
			operation.setTypeOperation(operation.getTypeOperation());
		crediter(operation.getComptSource().getRib(),operation.getMontant());
	    
		return 1;
		}
			return -1;
		}
	
			
	@Override
		public int debiter(String rib,Long montant) {
		Compte c =compteService.findByRib(rib);

		if(c==null)return -1;
		else if(c.getSolde()<montant) {
			return -2;
		}else {
			
			c.setSolde(c.getSolde()-montant);
			Operation d= new Debit(montant, new Date(), c);
			TypeOperation typeOperation =typeOperationService.findByLibelle("debit");
			d.setTypeOperation(typeOperation);
			operationdao.save(d);
			compteDao.save(c);
			return 1;
		}
		}
	@Override
		public int crediter(String rib,Long montant) {
			Compte c =compteService.findByRib(rib);
			if(c==null)return -1;
				c.setSolde(c.getSolde()+montant);
				Operation o =new Operation(montant, new Date(), c);
				TypeOperation typeOperation =typeOperationService.findByLibelle("credit");
				o.setTypeOperation(typeOperation);
				operationdao.save(o);
				compteDao.save(c);
				return 1;
			}	
		@Override
		public int transfer(String ribsource,String ribdestination,Long montant) {
			Compte c =compteService.findByRib(ribsource);
			Compte c1 =compteService.findByRib(ribdestination);
			if(c==null)return -1;
			else {
				crediter(c1.getRib(),montant);
				debiter(c.getRib(), montant);
				TypeOperation typeOperation =typeOperationService.findByLibelle("versement");
				Operation o= new Transfer(montant, new Date(), c);
				o.setTypeOperation(typeOperation);
				operationdao.save(o);
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
		public String instance(String ref) {
			// TODO Auto-generated method stub
			Operation o=findByRef(ref);
			if(o instanceof Debit)
			return "Debit";
			else return null;
		}

		@Override
		public double calculeMensualite(double c, int duree) {
			double t=4.5/100;
			double t1=c*t/12;
			double t2=Math.pow(1+t/12,-1*duree);
			double t3=1-t2;
			return t1/t3;
		}

        @Transactional
		@Override
		public int deleteByComptSourceRib(String rib) { 
			// TODO Auto-generated method stub
			return operationdao.deleteByComptSourceRib(rib);
		}

        @Transactional
		@Override
		public int deleteByComDis(String rib) {
			return operationdao.deleteByComptDis(rib);
		}
}
