package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.TypeCompte;
import com.example.gestionbacaire.service.facade.TypeCompteService;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("/gestionbancaire/typeCompte")
public class TypeCompteRest {
	@Autowired
private TypeCompteService typeCompteService;

	/**
	 * @param libelle
	 * @return
	 * @see com.example.gestionbacaire.service.facade.TypeCompteService#findByLibelle(java.lang.String)
	 */
	
	public TypeCompte findByLibelle(String libelle) {
		return typeCompteService.findByLibelle(libelle);
	}

	/**
	 * @param typeCompte
	 * @return
	 * @see com.example.gestionbacaire.service.facade.TypeCompteService#save(com.example.gestionbacaire.bean.TypeCompte)
	 */
	@PostMapping("/")
	public int save(@RequestBody TypeCompte typeCompte) {
		return typeCompteService.save(typeCompte);
	}

	/**
	 * @return
	 * @see com.example.gestionbacaire.service.facade.TypeCompteService#findAll()
	 */
	@GetMapping("/")
	public List<TypeCompte> findAll() {
		return typeCompteService.findAll();
	}
	
}
