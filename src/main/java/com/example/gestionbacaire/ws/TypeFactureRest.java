package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.TypeFacture;
import com.example.gestionbacaire.service.facade.TypeFactureService;

@RestController
@RequestMapping("gestionbancaire/typefacture")
public class TypeFactureRest {
	@Autowired
	private TypeFactureService typeFactureService;

	@GetMapping("/libelle/{libelle}")
	public TypeFacture findByLibelle(@PathVariable String libelle) {
		return typeFactureService.findByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody TypeFacture typeFacture) {
		return typeFactureService.save(typeFacture);
	}

}
