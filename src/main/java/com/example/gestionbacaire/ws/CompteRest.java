package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.service.facade.CompteService;
@RestController 
@RequestMapping("gestionbancaire/compte")
public class CompteRest {
	@Autowired
private CompteService compteService;

	/**
	 * @param rib
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CompteService#findByRib(java.lang.String)
	 */
	public Compte findByRib(String rib) {
		return compteService.findByRib(rib);
	}

	/**
	 * @param compte
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CompteService#save(com.example.gestionbacaire.bean.Compte)
	 */
	@PostMapping("/")
	public int save(@RequestBody Compte compte) {
		return compteService.save(compte);
	}
}
