package com.example.Client.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.Courant;
import com.example.Client.bean.Epargne;
import com.example.Client.service.facade.CourantService;
import com.example.Client.service.facade.EpargneService;

@RestController
@RequestMapping("gestionbancaire/eparne")
public class EpargneRest1 {
	@Autowired
private EpargneService epargneService;

	/**
	 * @param courant
	 * @return
	 * @see com.example.Client.service.facade.CourantService#save(com.example.Client.bean.Courant)
	 */
	@PostMapping("/")
	public int save(@RequestBody Epargne courant) {
		return epargneService.save(courant);
	}
}
