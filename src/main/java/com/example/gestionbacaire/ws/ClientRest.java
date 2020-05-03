package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.service.facade.ClientService;

@RestController
@RequestMapping("gestionbancaire/client")
public class ClientRest {
	@Autowired
private ClientService clientService;

	/**
	 * @param cin
	 * @return
	 * @see com.example.gestionbacaire.service.facade.ClientService#findByCin(java.lang.String)
	 */
	@GetMapping("/cin/{cin}")
	public Client findByCin(@PathVariable String cin) {
		return clientService.findByCin(cin);
	}

	/**
	 * @param client
	 * @return
	 * @see com.example.gestionbacaire.service.facade.ClientService#save(com.example.gestionbacaire.bean.Client)
	 */
	@PostMapping("/")
	public int save(@RequestBody Client client) {
		return clientService.save(client);
	}
	
}
