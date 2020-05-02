package com.example.Client.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.CommandeCheque;
import com.example.Client.service.facade.ChequeService;

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
