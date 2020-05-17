package com.example.gestionbacaire.ws;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.service.facade.DebitService;
import com.example.gestionbacaire.service.facade.OparationService;
@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/operation")
public class OperationRest {
	@Autowired
	private OparationService operationService;
	@PostMapping("/")
	public int save(@RequestBody Operation operation) {
		return operationService.save(operation);
	}
	
    @GetMapping("/c/{c}/duree/{duree}")
	public double calculeMensualite(@PathVariable double c,@PathVariable int duree) {
		return operationService.calculeMensualite(c, duree);
	}
   
	@GetMapping("/ref/{ref}")
	public String instance(@PathVariable String ref) {
		return operationService.instance(ref);
	}


	@GetMapping("/rib/{rib}")
	public List<Operation> findByComptSourceRibOrderByDateDesc(@PathVariable String rib) {
		return operationService.findByComptSourceRibOrderByDateDesc(rib);
	}


		@PutMapping("/rib/{rib}/montant/{montant}")
		public int debiter(@PathVariable String rib,@PathVariable Long montant) {
			return operationService.debiter(rib, montant);
		}		
		public Operation findByRef(String ref) {
			return operationService.findByRef(ref);
		}
}
