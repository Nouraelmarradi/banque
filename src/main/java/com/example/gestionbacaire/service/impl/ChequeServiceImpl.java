package com.example.gestionbacaire.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Commande;
import com.example.gestionbacaire.bean.CommandeCheque;
import com.example.gestionbacaire.bean.EtatCommande;
import com.example.gestionbacaire.service.facade.ChequeDao;
import com.example.gestionbacaire.service.facade.ChequeService;
import com.example.gestionbacaire.service.facade.ClientService;
import com.example.gestionbacaire.service.facade.CommandeService;
import com.example.gestionbacaire.service.facade.EtatCommandeService;

@Service
public class ChequeServiceImpl implements ChequeService {
	@Autowired
    private ChequeDao chequeDao;
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private EtatCommandeService etatCommandeService;
	@Override
	public int save(CommandeCheque commandeCheque) {
	Commande c=	commandeService.CommandefindByRef(commandeCheque.getRef());
	Client c1=clientService.findByCin(commandeCheque.getClient().getCin());
	EtatCommande e=etatCommandeService.findByLibelle("initiale");
		if(c!=null)
		return -1;
		if(c1==null)
			return -2;
		else {
			commandeCheque.setDatedemmande(new Date());
			commandeCheque.setClient(c1);
			commandeCheque.setEtatCommande(e);
			commandeCheque.setNbPage(commandeCheque.getNbPage());
			commandeCheque.setPrix(commandeCheque.getPrix());
		    chequeDao.save(commandeCheque);
		    
		   return 1;
		}
	}

}
