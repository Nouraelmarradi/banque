package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gestionbacaire.bean.Employe;
import com.example.gestionbacaire.service.facade.EmployeService;

@Controller
@RequestMapping("gestionbancaire/employe")
public class EmployeRest {
	@Autowired
private EmployeService  employeService;
@PostMapping("/")
	public int save(@RequestBody Employe employe) {
		return employeService.save(employe);
	}
@GetMapping("/")
	public Employe findByCin(@PathVariable String cin) {
		return employeService.findByCin(cin);
	}
}
