package com.example.Client.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.TypeCompte;
import com.example.Client.service.facade.TypeCompteService;

@RestController
@RequestMapping("gestionbancaire/typecompte")
public class TypeCompteRest {
	@Autowired
private TypeCompteService typeCompteService;

	/**
	 * @param libelle
	 * @return
	 * @see com.example.Client.service.facade.TypeCompteService#findByLibelle(java.lang.String)
	 */
	@GetMapping("/libelle/{libelle}")
	public TypeCompte findByLibelle(@PathVariable String libelle) {
		return typeCompteService.findByLibelle(libelle);
	}

	/**
	 * @param typecompte
	 * @return
	 * @see com.example.Client.service.facade.TypeCompteService#save(com.example.Client.bean.TypeCompte)
	 */
	@PostMapping("/")
	public int save(@RequestBody TypeCompte typecompte) {
		return typeCompteService.save(typecompte);
	}

	/**
	 * @return
	 * @see com.example.Client.service.facade.TypeCompteService#findAll()
	 */
	@GetMapping("/")
	public List<TypeCompte> findAll() {
		return typeCompteService.findAll();
	}
}
