package com.example.gestionbacaire.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.Dao.FactureDao;
import com.example.gestionbacaire.Dao.OperationDao;
import com.example.gestionbacaire.Dao.TypeOperationDao;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Facture;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.bean.TypeFacture;
import com.example.gestionbacaire.bean.TypeOperation;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.FactureService;
import com.example.gestionbacaire.service.facade.TypeFactureService;
import com.example.gestionbacaire.service.facade.TypeOperationService;

@Service
public class FactureServiceImpl implements FactureService{
	@Autowired
private FactureDao factureDao;
	@Autowired
private CompteService compteService;
	@Autowired
	private CompteDao compteDao;
	@Autowired
	private OperationDao OperationDao; 
	@Autowired
	private TypeOperationDao typeOperationDao;
	@Autowired
	private TypeOperationService typeOperationService;
	@Autowired
	private TypeFactureService typeFactureService;
	@Override
	public Facture findByCompteRibOrderByDateFactureDesc(String rib) {
		
		return factureDao.findByCompteRibOrderByDateFactureDesc(rib);
	}

	@Override
	public Facture findByTypeFactureLibelle(String libelle) {
		
		return factureDao.findByTypeFactureLibelle(libelle);
	}

	@Override
	public int save(Facture facture) {
		
		Compte compte=compteService.findByRib(facture.getCompte().getRib());
		TypeFacture typeFacture=typeFactureService.findByLibelle(facture.getTypeFacture().getLibelle());
		 if(compte==null)
			return -1;
		else {
			double solde=compte.getSolde()-(facture.getMontant()+typeFacture.getPrix());
			if(compte.getSolde()<facture.getMontant()+typeFacture.getPrix()) {
				return -2;
			}
		facture.setCompte(compte);
		compte.setSolde(solde);
		compteDao.save(compte);
		facture.setDateFacture( new Date()); 
		Operation operation=new Operation(facture.getMontant(),new Date(), facture.getCompte());
		operation.setLibelle("facture"+typeFacture.getLibelle()+facture.getId());
		String s="facture"+"  " +typeFacture.getLibelle();
		TypeOperation	tp=	typeOperationService.findByLibelle(s);
			if(tp==null)
			{
				TypeOperation p=new TypeOperation(s);
			typeOperationDao.save(p);
			operation.setTypeOperation(p);
			facture.setTypeFacture(typeFacture);
			OperationDao.save(operation);
			factureDao.save(facture);
			return 1;}
			operation.setTypeOperation(tp);
			facture.setTypeFacture(typeFacture);
			OperationDao.save(operation);	
			factureDao.save(facture);
			return 2;
		
		}}}

