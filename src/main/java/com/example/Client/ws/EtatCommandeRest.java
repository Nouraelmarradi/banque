package com.example.Client.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.EtatCommande;
import com.example.Client.service.facade.EtatCommandeService;

@RestController
@RequestMapping("gestionbancaire/etatCommande")
public class EtatCommandeRest {
	@Autowired
private EtatCommandeService etatCommandeService;

	/**
	 * @param libelle
	 * @return
	 * @see com.example.Client.service.facade.EtatCommandeService#findByLibelle(java.lang.String)
	 */
	@GetMapping("/libelle/{libelle}")
	public EtatCommande findByLibelle(@PathVariable String libelle) {
		return etatCommandeService.findByLibelle(libelle);
	}

	/**
	 * @return
	 * @see com.example.Client.service.facade.EtatCommandeService#findAll()
	 */
	@GetMapping("/")
	public List<EtatCommande> findAll() {
		return etatCommandeService.findAll();
	}

	/**
	 * @param etatCommande
	 * @return
	 * @see com.example.Client.service.facade.EtatCommandeService#save(com.example.Client.bean.EtatCommande)
	 */
	@PostMapping("/")
	public int save(@RequestBody EtatCommande etatCommande) {
		return etatCommandeService.save(etatCommande);
	}
}
