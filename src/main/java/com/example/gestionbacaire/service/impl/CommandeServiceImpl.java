package com.example.gestionbacaire.service.impl;

	import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

	import com.example.gestionbacaire.Dao.CommandeDao;
	import com.example.gestionbacaire.bean.Client;
	import com.example.gestionbacaire.bean.Commande;
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
		@Autowired
	    private JavaMailSender sender;
	 
	    @Override
		public Commande findByRef(String ref) {
			return commandeDao.findByRef(ref);
		}
	    
	    @Override
		public int modifieEtat(String etat, Commande c) {
		Commande commande=commandeDao.findById(c.getId()).get();
		EtatCommande etatCommande=etatCommandeService.findByLibelle(etat);
		if(commande==null) {
			return -1;}
		else {
			commande.setEtatCommande(etatCommande);
			commande.setMessage("Votre Commande"+" "+ "est"+" "+commande.getEtatCommande().getLibelle());
		commandeDao.save(commande);
		try {
            sendEmail(commande.getCompte().getClient().getEmail(), commande.getMessage(),"Notification de demmande de chéquire");
System.out.println(commande.getMessage());
            return 15;
        }catch(Exception ex) {
            System.out.println(ex);
        }
		return 1;
		}}
	    
	    @Override
	    public int save(Commande c) {
	    	Compte compte=compteService.findByRib(c.getCompte().getRib());
	    	EtatCommande e=etatCommandeService.findByLibelle("initiale");
	    		 if(compte==null) {
	    			return -2;	
	    		}
	    		 else {
	    			c.setCompte(compte);
	    			c.setDatedemmande(new Date());
	    		    c.setEtatCommande(e);
	    		    c.setNbPage(c.getNbPage());
	    		    c.setQt(c.getQt());;
	    		    commandeDao.save(c);
	    		    return 1;
	    		}
	    }
	    private void sendEmail(String email,String text,String sub) throws Exception{
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	         
	        helper.setTo(email);
	        helper.setText(text);
	        helper.setSubject(sub);
	         
	        sender.send(message);
	    }

		@Override
		public List<Commande> findAll() {
			// TODO Auto-generated method stub
			return commandeDao.findAll();
		}
		@Override
		public List<Commande> fininitaile() {
			List<Commande> c=commandeDao.findAll();
			List<Commande> cs=new ArrayList<Commande>();
			for(Commande commande:c) {
				if(commande.getEtatCommande().getLibelle().equals("initiale")) {
				cs.add(commande);	
				}
			}
			return cs;
		}
		@Override
		public List<Commande> finsrehete() {
			List<Commande> c=commandeDao.findAll();
			List<Commande> cs=new ArrayList<Commande>();
			for(Commande commande:c) {
				if(commande.getEtatCommande().getLibelle().equals("rejete")) {
				cs.add(commande);	
				}
			}
			return cs;
		}
		@Override
		public List<Commande> finaccepte() {
			List<Commande> c=commandeDao.findAll();
			List<Commande> cs=new ArrayList<Commande>();
			for(Commande commande:c) {
				if(commande.getEtatCommande().getLibelle().equals("accepte")) {
				cs.add(commande);	
				}
			}
			return cs;
		}

		
		@Override 
		public String findByCompteRib(String rib) {
			
			return commandeDao.findByCompteRib(rib).getMessage();
		}
	    
	}


