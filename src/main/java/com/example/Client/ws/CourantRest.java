package com.example.Client.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Client.bean.Courant;
import com.example.Client.service.facade.CourantService;

@RestController
@RequestMapping("gestionbancaire/courant")
public class CourantRest {
	@Autowired
private CourantService courantService;

	/**
	 * @param courant
	 * @return
	 * @see com.example.Client.service.facade.CourantService#save(com.example.Client.bean.Courant)
	 */
	@PostMapping("/")
	public int save(@RequestBody Courant courant) {
		return courantService.save(courant);
	}
}
