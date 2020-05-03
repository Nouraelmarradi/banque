package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.CommandeCheque;
import com.example.gestionbacaire.service.facade.ChequeService;

@RestController
@RequestMapping("gestionbancaire/cheque")
public class ChequeRest {
	@Autowired
private ChequeService chequeService;
@PostMapping("/")
	public int save(@RequestBody CommandeCheque commandeCheque) {
		return chequeService.save(commandeCheque);
	}
}
