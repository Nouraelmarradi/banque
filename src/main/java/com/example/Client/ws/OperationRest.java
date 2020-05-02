package com.example.Client.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.Operation;
import com.example.Client.service.facade.OparationService;
@RestController
@RequestMapping("gestionbancaire/operation")
public class OperationRest {
	@Autowired
	private OparationService operationService;
    @GetMapping("/c/{c}/duree/{duree}/taux/{taux}")
	public double calculeMensualite(@PathVariable double c,@PathVariable int duree,@PathVariable double taux) {
		return operationService.calculeMensualite(c, duree, taux);
	}


	@GetMapping("/ref/{ref}")
	public int instance(@PathVariable String ref) {
		return operationService.instance(ref);
	}


	@GetMapping("/rib/{rib}")
	public List<Operation> findAllByComptSourceRib(@PathVariable String rib) {
		return operationService.findAllByComptSourceRib(rib);
	}


	@GetMapping("/")
	public List<Operation> findAllByOrderByDateDesc() {
		return operationService.findAllByOrderByDateDesc();
	}


		@PutMapping("/rib/{rib}/montant/{montant}")
		public int debiter(@PathVariable String rib,@PathVariable double montant) {
			return operationService.debiter(rib, montant);
		}

		
		@PostMapping("/")
		public int save(@RequestBody Operation operation) {
			return operationService.save(operation);
		}

		
		public Operation findByRef(String ref) {
			return operationService.findByRef(ref);
		}
}
