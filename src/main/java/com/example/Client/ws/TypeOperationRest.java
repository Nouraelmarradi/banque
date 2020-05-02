package com.example.Client.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.TypeOperation;
import com.example.Client.service.facade.TypeOperationService;

@RestController
@RequestMapping("gestionbancaire/typeopertion")
public class TypeOperationRest {
	@Autowired
private TypeOperationService typeOperationService;

	/**
	 * @param libelle
	 * @return
	 * @see com.example.Client.service.facade.TypeOperationService#findByLibelle(java.lang.String)
	 */
	@GetMapping("/libelle/{libelle}/")
	public TypeOperation findByLibelle(@PathVariable String libelle) {
		return typeOperationService.findByLibelle(libelle);
	}

	/**
	 * @param typeOperation
	 * @return
	 * @see com.example.Client.service.facade.TypeOperationService#save(com.example.Client.bean.TypeOperation)
	 */
	@PostMapping("/")
	public int save(@RequestBody TypeOperation typeOperation) {
		return typeOperationService.save(typeOperation);
	}

	/**
	 * @return
	 * @see com.example.Client.service.facade.TypeOperationService#findAll()
	 */
	@GetMapping("/")
	public List<TypeOperation> findAll() {
		return typeOperationService.findAll();
	}
}
