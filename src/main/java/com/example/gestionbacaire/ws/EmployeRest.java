package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Employe;
import com.example.gestionbacaire.service.facade.EmployeService;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/employe")
public class EmployeRest {
	@Autowired
private EmployeService employeService;
	
	@GetMapping("/Userusername/{username}")
	public Employe findByUserUsername(@PathVariable String username) {
		// TODO Auto-generated method stub
		return employeService.findByUserUsername(username);
	}
	@GetMapping("/num/{num}")
	public List<Employe> findByAgencenumero(@PathVariable Long num) {
		return employeService.findByAgencenumero(num);
	}
public Employe findByCin(String cin) {
		return employeService.findByCin(cin);
	}


	/**
	 * @param employe
	 * @return
	 * @see com.example.gestionbacaire.service.facade.EmployeService#save(com.example.gestionbacaire.bean.Employe)
	 */
	@PostMapping("/")
	public int save(@RequestBody Employe employe) {
		return employeService.save(employe);
	}
	@GetMapping("/username/{username}")
	public Employe findByUsername(@PathVariable String username) {
		return employeService.findByUsername(username);
	}

	/**
	 * @param client
	 * @return
	 * @see com.example.gestionbacaire.service.facade.ClientService#login(com.example.gestionbacaire.bean.Client)
	 */
	@GetMapping("/login/username/{username}/passwold/{passwed}")
	public int 	login(@PathVariable String username,@PathVariable String passwed) {
		return employeService.login(username, passwed);
	}
	

	
	@PutMapping("/put")
	public int Update(@RequestBody Employe employe) {
		return employeService.Update(employe);
	}
	@DeleteMapping("/delete/cin/{cin}")
	public int delete(@PathVariable String cin) {
		return employeService.delete(cin);
	}
	@GetMapping("/")
	public List<Employe> findAll() {
	
		return employeService.findAll();
	}
	

}
