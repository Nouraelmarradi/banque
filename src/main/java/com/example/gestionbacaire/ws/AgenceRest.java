package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Agence;
import com.example.gestionbacaire.service.facade.AgenceService;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/agence")
public class AgenceRest {
    @Autowired
	private AgenceService agenceService;

	/**
	 * @param long1
	 * @return
	 * @see com.example.gestionbacaire.service.facade.AgenceService#findByNumero(java.lang.Long)
	 */
	public Agence findByNumero(Long long1) {
		return agenceService.findByNumero(long1);
	}

	/**
	 * @param agence
	 * @return
	 * @see com.example.gestionbacaire.service.facade.AgenceService#save(com.example.gestionbacaire.bean.Agence)
	 */
	@PostMapping("/")
	public int save(@RequestBody Agence agence) {
		return agenceService.save(agence);
	}

	
	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Agence> findAll() {
		return agenceService.findAll();
	}

}
