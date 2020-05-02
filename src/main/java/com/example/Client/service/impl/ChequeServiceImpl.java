package com.example.Client.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Client.bean.Client;
import com.example.Client.bean.Commande;
import com.example.Client.bean.CommandeCheque;
import com.example.Client.bean.EtatCommande;
import com.example.Client.service.facade.ChequeDao;
import com.example.Client.service.facade.ChequeService;
import com.example.Client.service.facade.ClientService;
import com.example.Client.service.facade.CommandeService;
import com.example.Client.service.facade.EtatCommandeService;

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
