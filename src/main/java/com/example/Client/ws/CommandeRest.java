package com.example.Client.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.service.facade.CommandeService;

@RestController
@RequestMapping("gestionbancaire/commande")
public class CommandeRest {
	@Autowired
private CommandeService commandeService;
}
