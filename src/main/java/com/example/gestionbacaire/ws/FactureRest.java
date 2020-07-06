package com.example.gestionbacaire.ws;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Facture;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.service.facade.FactureService;
import com.example.gestionbacaire.service.utile.GeneratePdfRepor;
import com.example.gestionbacaire.service.utile.PdfFacture;
import com.example.gestionbacaire.ws.converter.vo.ProduitVo;
import com.example.gestionbacaire.ws.converter.vo.extange.FactureVo;
import com.example.gestionbacaire.ws.proxy.ProduitProxy;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))

@RequestMapping("gestionbancaire/facture")
public class FactureRest {
	@Autowired
	private ProduitProxy factureProxy;
	@Autowired
	private CompteDao compteDao;
	
	@Autowired
private FactureService factureService;
	@GetMapping("/rib/{rib}")
	public Facture findByCompteRibOrderByDateFactureDesc(@PathVariable String rib) {
		return factureService.findByCompteRibOrderByDateFactureDesc(rib);
	}
@GetMapping("/libelle/libelle")
	public Facture findByTypeFactureLibelle(@PathVariable String libelle) {
		return factureService.findByTypeFactureLibelle(libelle);
	}
@PostMapping("/")
	public int save(@RequestBody Facture facture) {
		return factureService.save(facture);
	}
@GetMapping("/reference/{li}")
public List<FactureVo> git(@PathVariable String li) {
	return factureProxy.nopay(li);
}
@PutMapping("/reference/{id}")
public int gitme(@PathVariable String id,@RequestBody Compte compte) {
	FactureVo f=factureProxy.findByRef(id);
	Compte c=compteDao.findByRib(compte.getRib());
	if(c==null) {return -1;}
	else if(f==null) {
	return -2;
	}
		c.setSolde(c.getSolde()-f.getMontant());
	compteDao.save(c);
	return 1;
}
@PutMapping("/reference")
public int git(@RequestBody Facture facture) {
	FactureVo f=factureProxy.findById(facture.getId());
	Compte c=compteDao.findByRib(facture.getCompte().getRib());
	if(c==null) {return -1;}
	else if(f==null) {
	return -2;
	}
		c.setSolde(c.getSolde()-f.getMontant());
	compteDao.save(c);
	 return 1;
}
@RequestMapping(value = "/pdfreport/rib/{rib}/num/{num}", method = RequestMethod.GET,
produces = MediaType.APPLICATION_PDF_VALUE)
public ResponseEntity<InputStreamResource> findByall(@PathVariable String rib,@PathVariable Long num){
	FactureVo f=factureProxy.findById(num);

ByteArrayInputStream bis = PdfFacture.citiesReport(rib,num,f.getMontant());


new HttpHeaders().add("Content-Disposition", "inline filename=citiesreport.pdf");

return ResponseEntity
    .ok()
    .headers(new HttpHeaders())
    .contentType(MediaType.APPLICATION_PDF)
    .body(new InputStreamResource(bis));
}
}