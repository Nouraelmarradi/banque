package com.example.gestionbacaire.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.gestionbacaire.Dao.CalculeDao;
import com.example.gestionbacaire.Dao.ClientDao;
import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.Dao.UserRepository;
import com.example.gestionbacaire.bean.Agence;
import com.example.gestionbacaire.bean.Calulcule;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Employe;
import com.example.gestionbacaire.bean.User;
import com.example.gestionbacaire.service.facade.AgenceService;
import com.example.gestionbacaire.service.facade.ClientService;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.EmployeService;
import com.example.gestionbacaire.service.utile.PasswordUtils;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
private ClientDao clientDao;
	@Autowired
private CompteDao compteDao;
	@Autowired
private CompteService compteService;
	@Autowired
private AgenceService agenceService;
	@Autowired
	private EmployeService employeService ;
	@Autowired
private UserRepository userRepository;	
	@Autowired
private CalculeDao calculeDao;
	@Autowired
    private JavaMailSender sender;
	@Override
	public Client findByCin(String cin) {
		// TODO Auto-generated method stub
		return clientDao.findByCin(cin);
	}
	@Override
	public int savev2(Client client) {
Client c=findByCin(client.getCin());
		//User u=userRepository.findByUsername(client.getCin());
		Agence agence=agenceService.findByNumero(client.getAgence().getNumero());
		if(c!=null) {
			return -1;
		}
		else {
			if(agence==null) {
				return -2;
			}
		client.setEmploye(null);
		client.setAgence(agence);
		client.setDate(new Date());
		clientDao.save(client)	;
		Calulcule cal=calculeDao.findByMois(client.getDate().getMonth());
		if(cal.getAnne()==client.getDate().getYear()) {
cal.setNb(cal.getNb()+1);
		calculeDao.save(cal);}
		return 1;
	}}
	@Override
public int like() {
	Calulcule cal=calculeDao.findByMois(2);
	return 1;

}
	@Override
public int dselike() {
	Calulcule cal=calculeDao.findByMois(2);
	return 1;

}
	@Override
	public int save(Client client) {
		Client c=findByCin(client.getCin());
	    
		//User u=userRepository.findByUsername(client.getCin());
		Agence agence=agenceService.findByNumero(client.getAgence().getNumero());
		 // Generate Salt. The generated value can be stored in DB. 
        String salt = PasswordUtils.getSalt(30);
        
   
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(client.getPassworld(), salt);
        
        // Print out protected password 
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);
		if(c!=null)
			{return -1;}
		else if(agence==null)
			{return -2;}
		else {
			client.setAgence(agence);
			client.setSalt(salt);
			client.setPassworld(mySecurePassword);
			client.setDate(new Date());
			
			
			clientDao.save(client)	;
			Calulcule cal=calculeDao.findByMois(client.getDate().getMonth());
if(cal.getAnne()==client.getDate().getYear()) {
			cal.setNb(cal.getNb()+1);
			calculeDao.save(cal);
			client.getDate().getMonth();
		    System.out.println( client.getDate().getMonth());
		    System.out.println( client.getDate().getDay());
		    System.out.println( client.getDate().getHours());

			return 1;}
else {
	return 0;
}
		}
		
	}
	@Override
	public Client findByUsername(String username) {
		return clientDao.findByUsername(username);
	}
	


@Override	
public int 	login(String username,String passwed) {
	  Client ct=findByUsername(username);
	  if(ct==null) {
		  return -1;
	  }
      boolean passwordMatch = PasswordUtils.verifyUserPassword(passwed,ct.getPassworld() ,ct.getSalt());
      if(passwordMatch) 
      {
    	  findByUsername(ct.getUsername());
    	  compteService.findByClientCin(ct.getCin());
   
return 1;
      } else {
        return   -2;
      }
  }
@Override
public int verifier(String pass,Client ct) {
	 boolean passwordMatch = PasswordUtils.verifyUserPassword(pass,ct.getPassworld() ,ct.getSalt());
     if(passwordMatch) 
     {
   	  return 1;
}
     return -1;}
public int updatelogin(Client client) {
	Client ct=findByUsername(client.getUsername());
	if(ct==null) {
		ct.setPassworld(client.getPassworld());
		ct.setUsername(client.getUsername());
		return 1;
	}
	else {
		return -1;
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
public int	verigfy(Compte c) {
	Compte compte= compteService.findByRib(c.getRib());
	if(compte==null) {
		return -1;
	}
	else {
		
		compte.getClient().setCodeContrat(compte.getId());
		clientDao.save(compte.getClient());
		String mail=compte.getClient().getEmail();		
		try {
			sendEmail(mail,"Votre code d'activation est  "+compte.getClient().getCodeContrat(),"CODE D'activation du compte");
           
            return 15;
        }catch(Exception ex) {
            System.out.println(ex);
        }
		return 1;
	}
}
@Override
public int	verigy(Compte c) {
	Compte compte= compteService.findByRib(c.getRib());
	if(compte==null) {
		return -1;
	}
	else {
		compte.getClient().setCodeContrat(compte.getId());
		clientDao.save(compte.getClient());
		String mail=compte.getClient().getEmail();		
		try {
			sendEmail(mail,"Votre code d'activation est  "+compte.getClient().getCodeContrat(),"CODE D'activation du compte");
           
            return 15;
        }catch(Exception ex) {
            System.out.println(ex);
        }
		return 1;
	}
}

@Override
public int demmande(Compte c) {
	Compte compte= compteService.findByRib(c.getRib());
	if(compte==null) {
		return -1;
	}
	else {
		clientDao.save(compte.getClient());
		String mail=compte.getClient().getEmail();		
		try {
			sendEmail(mail,"Votre Rib "+compte.getRib(),"Demmande de Rib");
           
            return 15;
        }catch(Exception ex) {
            System.out.println(ex);
        }
		return 1;
	}
}
@Override
public	int registre(Client client) {
		Client c=clientDao.findByCodeContrat(client.getCodeContrat());
		if(c==null) {return -1;}
			 String salt = PasswordUtils.getSalt(30);
		        // Protect user's password. The generated value can be stored in DB.
		        String mySecurePassword = PasswordUtils.generateSecurePassword(client.getPassworld(), salt);
		        c.setSalt(salt);
		        c.setUsername(client.getUsername());
				c.setPassworld(mySecurePassword);
				clientDao.save(c);
				return 1; 
		}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientDao.findAll();
	}
   @Transactional
	@Override
	public int deleteByCin(String cin) {
	int res2=compteService.deleteAll(cin);
	int res1=clientDao.deleteByCin(cin);
		return res1*res2;
	}
   @Override
   public int uppdate(Client client) {
	   Client c=clientDao.findById(client.getId()).get();
	   if(c==null) {return -1;}
	   else {
		   c.setNom(client.getNom());
		   c.setCin(client.getCin());
		   clientDao.save(c);
		   return 1;
	   }
   }
@Override
public Client findByUserUsername(String username) {
	// TODO Auto-generated method stub
	return clientDao.findByUserUsername(username);
}
}
