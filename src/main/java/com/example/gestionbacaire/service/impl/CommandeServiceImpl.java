package com.example.gestionbacaire.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CommandeDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Commande;
import com.example.gestionbacaire.bean.CommandeCheque;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.EtatCommande;
import com.example.gestionbacaire.bean.Typecommande;
import com.example.gestionbacaire.service.facade.ClientService;
import com.example.gestionbacaire.service.facade.CommandeService;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.EtatCommandeService;
import com.example.gestionbacaire.service.facade.TypeCommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{
	@Autowired
private CommandeDao commandeDao;
	@Autowired
private EtatCommandeService etatCommandeService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CompteService compteService;
	@Autowired
	private TypeCommandeService typeCommandeService;
    @Override
	public Commande findByRef(String ref) {
		return commandeDao.findByRef(ref);
	}
    @Override
	public int modifieEtat(String etat, String ref) {
	Commande c=findByRef(ref);
	EtatCommande etatCommande=etatCommandeService.findByLibelle(etat);
	if(c==null) {
		return -1;}
	else {
	c.setEtatCommande(etatCommande);
	commandeDao.save(c);
	return 1;
	}}
    @Override
    public int save(Commande c) {
    	Compte compte=compteService.findByRib(c.getCompte().getRib());
    	EtatCommande e=etatCommandeService.findByLibelle("initiale");
    	Typecommande typecommande=typeCommandeService.findByLibelle(c.getTypecommande().getLibelle());
    		 if(compte==null) {
    			return -2;	
    		}
    		 else  if(typecommande==null) {
     			return -1;}
    		 else {
    			 if(compte.getSolde()<typecommande.getPrix())
    			 {return -3;}
    			 compte.setSolde(compte.getSolde()-typecommande.getPrix());
    			c.setCompte(compte);
    			c.setDatedemmande(new Date());
    		    c.setEtatCommande(e);
    		    c.setTypecommande(typecommande);
    		    commandeDao.save(c);
    		    return 1;
    		}
    }
    
}