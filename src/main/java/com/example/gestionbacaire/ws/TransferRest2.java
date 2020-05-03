package com.example.gestionbacaire.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.bean.Transfer;
import com.example.gestionbacaire.service.facade.OparationService;
import com.example.gestionbacaire.service.facade.TransferService;
@RestController
@RequestMapping("gestionbancaire/transfer")
public class TransferRest2 {
	@Autowired
	private TransferService transferService;

		/**
	 * @param rib
	 * @return
	 * @see com.example.gestionbacaire.service.facade.TransferService#findByComptSourceRibOrderByDateDesc(java.lang.String)
	 */
	@GetMapping("/rib/{rib}")
	public List<Operation> findByComptSourceRibOrderByDateDesc(@PathVariable String rib) {
		return transferService.findByComptSourceRibOrderByDateDesc(rib);
	}

		@PostMapping("/")
		public int save(@RequestBody Transfer transfer) {
			return  transferService.save(transfer);
		}

		public Operation findByRef( String ref) {
			return  transferService.findByRef(ref);
		}
}