package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Commande;
import com.example.gestionbacaire.service.facade.CommandeService;

@RestController
@RequestMapping("gestionbancaire/commande")
public class CommandeRest {
	@Autowired
private CommandeService commandeService;

	@PostMapping("/")
	public int save(@RequestBody Commande c) {
		return commandeService.save(c);
	}

	public Commande findByRef(String ref) {
		return commandeService.findByRef(ref);
	}

	
	@PutMapping("/etat/{etat}/ref/{ref}")
	public int modifieEtat(@PathVariable String etat,@PathVariable String ref) {
		return commandeService.modifieEtat(etat, ref);
	}
}
