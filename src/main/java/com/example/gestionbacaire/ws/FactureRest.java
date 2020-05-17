package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Facture;
import com.example.gestionbacaire.service.facade.FactureService;

@RestController
@RequestMapping("gestionbancaire/facture")
public class FactureRest {
	@Autowired
private FactureService factureService;
	@GetMapping("/rib/{rib}")
	public Facture findByCompteRibOrderByDateFactureDesc(@PathVariable String rib) {
		return factureService.findByCompteRibOrderByDateFactureDesc(rib);
	}
@GetMapping("/libelle/libelle")
	public Facture findByTypeFactureLibelle(@PathVariable String libelle) {
		return factureService.findByTypeFactureLibelle(libelle);
	}
@PostMapping("/")
	public int save(@RequestBody Facture facture) {
		return factureService.save(facture);
	}
}
