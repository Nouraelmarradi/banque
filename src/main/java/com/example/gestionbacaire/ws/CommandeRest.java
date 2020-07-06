package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.Dao.CommandeDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Commande;
import com.example.gestionbacaire.service.facade.CommandeService;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/commande")
public class CommandeRest {
	@Autowired
private CommandeService commandeService;
	@Autowired
private CommandeDao commandeDao;
	/**
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CommandeService#fininitaile()
	 */
	@GetMapping("/initaile")
	public List<Commande> fininitaile() {
		return commandeService.fininitaile();
	}

	/**
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CommandeService#finsrehete()
	 */
	@GetMapping("/rejete")
	public List<Commande> finsrehete() {
		return commandeService.finsrehete();
	}

	/**
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CommandeService#finaccepte()
	 */
	@GetMapping("/accepte")
	public List<Commande> finaccepte() {
		return commandeService.finaccepte();
	}

	/**
	 * @param rib
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CommandeService#findByCompteRib(java.lang.String)
	 */
	@GetMapping("/message/rib/{rib}")
	public String findByCompteRib(@PathVariable String rib) {
		return commandeService.findByCompteRib(rib);
	}

	@GetMapping
	  public Page<Commande> list(@RequestParam(name = "page", defaultValue = "0") int page,
	                                 @RequestParam(name = "size", defaultValue = "5") int size) {
	    PageRequest pageRequest = PageRequest.of(page, size);
	    Page<Commande> pageResult = commandeDao.findAll(pageRequest);
	    return pageResult;
	 
	  }
	/**
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CommandeService#findAll()
	 */
	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Commande c) {
		return commandeService.save(c);
	}

	public Commande findByRef(String ref) {
		return commandeService.findByRef(ref);
	}

	
	@PutMapping("/etat/{etat}")
	public int modifieEtat(@PathVariable String etat, @RequestBody Commande c) {
		return commandeService.modifieEtat(etat, c);
	}
}
