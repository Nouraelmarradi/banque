package com.example.gestionbacaire.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Courant;
import com.example.gestionbacaire.bean.Epargne;
import com.example.gestionbacaire.service.facade.CourantService;
import com.example.gestionbacaire.service.facade.EpargneService;

@RestController
@RequestMapping("gestionbancaire/epargne")
public class EpargneRest {
	@Autowired
private EpargneService epargneService;

	/**
	 * @param courant
	 * @return
	 * @see com.example.gestionbacaire.service.facade.CourantService#save(com.example.gestionbacaire.bean.Courant)
	 */
	@PostMapping("/")
	public int save(@RequestBody Epargne courant) {
		return epargneService.save(courant);
	}
}
