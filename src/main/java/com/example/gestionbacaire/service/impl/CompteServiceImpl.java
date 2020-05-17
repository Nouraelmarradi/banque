package com.example.gestionbacaire.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.TypeCompte;
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
	
	@Override
	public Compte findByRib(String rib) {
		// TODO Auto-generated method stub
		return compteDao.findByRib(rib);
	}
	
	@Override
	public int save(Compte compte) {
		Compte c =findByRib(compte.getRib());
		Client client=clientService.findByCin(compte.getClient().getCin());
		TypeCompte typeCompte=typeCompteService.findByLibelle(compte.getTypeCompte().getLibelle());
		if(c!=null)
			return -1;
		if(client==null)return -2;
		else {
			compte.setClient(client);
			compte.setEmploye(null);
			compte.setDevise(null);
			compte.setTypeCompte(typeCompte);
			compteDao.save(compte);
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
}
