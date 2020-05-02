package com.example.Client.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.Debit;
import com.example.Client.service.facade.DebitService;
@RestController
@RequestMapping("gestionbancaire/debit")
public class DebitRest {
	@Autowired
	private DebitService debitService;

	
		
		@PostMapping("/")
		public int save(@RequestBody Debit debit) {
			return debitService.save(debit);
		}

		
}
