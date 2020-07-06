package com.example.gestionbacaire.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CalculeDao;
import com.example.gestionbacaire.Dao.ClientDao;
import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.bean.Agence;
import com.example.gestionbacaire.bean.Calulcule;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.TypeCompte;
import com.example.gestionbacaire.service.facade.AgenceService;
import com.example.gestionbacaire.service.facade.ClientService;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.OparationService;
import com.example.gestionbacaire.service.facade.TypeCompteService;

@Service
public class CompteServiceImpl implements CompteService {
	@Autowired
	private CompteDao compteDao;
		@Autowired
		private ClientService clientService;
		@Autowired
		private TypeCompteService typeCompteService;
		@Autowired
		private OparationService operationService;
		@Autowired
		private AgenceService agenceService;
		@Autowired
		private CalculeDao calculeDao;
		
		
		
		@Override
		public List<Compte> findByClientUsername(String Username) {
			// TODO Auto-generated method stub
			return compteDao.findByClientUsername(Username);
		}
		@Override
		public Compte findByRib(String rib) {
			// TODO Auto-generated method stub
			return compteDao.findByRib(rib);
		}
		public  String Formater(String texte,int longueur){

			 
			while (texte.length()<longueur) { texte="0"+texte;
			
		}
			return texte;}
		@Override
		public int save(Compte compte) {
			
		   Client client=clientService.findByCin(compte.getClient().getCin());
		    Agence agence=agenceService.findByNumero(client.getAgence().getNumero());   
		    if(agence==null)
				return -3;
			if(client==null) {return -2;}else {
			String txtCompte=Formater(compte.getId().toString(),11);
			String txtGuichet=Formater(client.getAgence().getNumero().toString(),5);
			String txtBanque=Formater(agence.getBanque().getCodeBanque().toString(),5);
		  int cle = 97 - ( ( 89 * Integer.parseInt(txtBanque)+ 15 * Integer.parseInt(txtGuichet) + 3 * Integer.parseInt(txtCompte)  ) % 97);
			String ss=txtBanque;
			StringBuffer sb = new StringBuffer(txtBanque);
			sb.append(txtGuichet);
			sb.append(txtCompte);
			sb.append(cle);	
			String stringrib=sb.toString();
			TypeCompte typeCompte=typeCompteService.findByLibelle(compte.getTypeCompte().getLibelle());
				compte.setClient(client);
				compte.setEmploye(null);
				compte.setDevise(null);
				compte.setRib(stringrib);
				compte.setTypeCompte(typeCompte);
				compteDao.save(compte);
				Calulcule cal=calculeDao.findByMois(client.getDate().getMonth());
				cal.setNb(cal.getNom()+1);
						calculeDao.save(cal);
				return 1;
			}
		}
	    @Transactional
		@Override
		public int deleteByRib(String rib) {
	    	
	    	int res2=operationService.deleteByComptSourceRib(rib);
	    	compteDao.deleteByRib(rib);
			return res2;
		}
	public int deleteAll(String cin) {
	List<Compte>comptes=findByClientCin(cin);
	int count=0;
	for(Compte compte:comptes) {
		deleteByRib(compte.getRib());
		count++;
	}	
	return count;
	}

	@Override
	public List<Compte> findByClientCin(String cin) {
		return compteDao.findByClientCin(cin);
	}
	@Override
	public List<Compte>findAll(){
		return compteDao.findAll();
	}
	@Override
	public List<Compte>findAllbyRech(String rib){
		List<Compte>c=new ArrayList<Compte>();
		List<Compte>cs=compteDao.findAll();
		for(Compte cop:cs) {
			if(cop.getRib().equals(rib)) {
				c.add(cop);
			}
		}
		return c;
	}

	@Override
	public int updateCompte(Compte c) {
		Compte co= compteDao.findById(c.getId()).get();
		TypeCompte t=typeCompteService.findByLibelle(c.getTypeCompte().getLibelle());
		Client client= clientService.findByCin(c.getClient().getCin());
		if(co==null) {return -1;}
		if(t==null) {return -2;}
		if(client==null) {return -3;}
		else {
		co.setSolde(c.getSolde());
		co.setTypeCompte(t);
		co.setClient(client);
		compteDao.save(co);	
		return 1;
	}}

}
