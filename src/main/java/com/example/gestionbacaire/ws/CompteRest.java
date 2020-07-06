package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.service.facade.CompteService;
@RestController 
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/compte")
public class CompteRest {
	@Autowired
private CompteService compteService;
	@Autowired
	private CompteDao compteDao;

	
		/**
	 * @param rib
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CompteService#findAllbyRech(java.lang.String)
	 */
	@GetMapping("rechrche/rib/{rib}")
	public List<Compte> findAllbyRech(@PathVariable String rib) {
		return compteService.findAllbyRech(rib);
	}
		@PutMapping("/updatecompte/")
		public int updateCompte(@RequestBody Compte c) {
			return compteService.updateCompte(c);
		}
		public int deleteByRib(String rib) {
			return compteService.deleteByRib(rib);
		}
		@GetMapping
		  public Page<Compte> list(@RequestParam(name = "page", defaultValue = "0") int page,
		                                 @RequestParam(name = "size", defaultValue = "10") int size) {
		    PageRequest pageRequest = PageRequest.of(page, size);
		    Page<Compte> pageResult = compteDao.findAll(pageRequest);
		    return pageResult;
		 
		  }
		@GetMapping("/findByClientUserUsername/Username")
		Compte findByClientUserUsername(@PathVariable String Username) {
			return compteDao.findByClientUserUsername(Username);
		}

        @GetMapping("/cin/{cin}")		
		public List<Compte> findByClientCin(@PathVariable String cin) {
			return compteService.findByClientCin(cin);
		}

        @GetMapping("/Username/{username}")		
		public List<Compte> findByClientUsername(@PathVariable String username) {
			return compteService.findByClientUsername(username);
		}

		@DeleteMapping("/delete/{rib}")
		public int delete(@PathVariable String rib) {
			return compteService.deleteByRib(rib);
		}

		@GetMapping("/")
		public List<Compte> findAll() {
			return compteService.findAll();
		}
		public Compte findByRib(String rib) {
			return compteService.findByRib(rib);
		}

		
		@PostMapping("/")
		public int save(@RequestBody Compte compte) {
			return compteService.save(compte);
		}
}
