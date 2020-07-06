package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.Dao.CalculeDao;
import com.example.gestionbacaire.bean.Calulcule;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/calcule")
public class CalculeRest {
	@Autowired
	private CalculeDao calculeDao;
	@GetMapping("/")
	private List<Calulcule>findAll() {
return calculeDao.findAll();}
	@GetMapping("/anne/{anne}")
public List<Calulcule> findByAnne( @PathVariable int anne){
	return calculeDao.findByAnne(anne);
}


}