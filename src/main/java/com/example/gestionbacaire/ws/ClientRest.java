package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.Dao.ClientDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.service.facade.ClientService;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/client")
public class ClientRest {
	@Autowired
private ClientService clientService;
	

	@Autowired
	private ClientDao clientDao;
		
	public List<Client> findAll() {
		return clientService.findAll();
	}
	
	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return clientService.deleteByCin(cin);
	}
	
	@GetMapping
	  public Page<Client> list(@RequestParam(name = "page", defaultValue = "0") int page,
	                                 @RequestParam(name = "size", defaultValue = "5") int size) {
	    PageRequest pageRequest = PageRequest.of(page, size);
	    Page<Client> pageResult = clientDao.findAll(pageRequest);
	    return pageResult;
	 
	  }
	

	@GetMapping("/cin/{cin}")
	public Client findByCin(@PathVariable String cin) {
		return clientService.findByCin(cin);
	}

	
	@PostMapping("/")
	public int save(@RequestBody Client client) {
		return clientService.save(client);
	}
	
}
