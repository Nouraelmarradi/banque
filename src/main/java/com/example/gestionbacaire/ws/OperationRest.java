package com.example.gestionbacaire.ws;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.naming.ldap.SortResponseControl;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.Dao.OperationDao;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.OparationService;
import com.example.gestionbacaire.service.utile.GeneratePdfRepor;
import com.itextpdf.text.DocumentException;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;
import net.sf.jasperreports.engine.JRException;
@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/operation")
public class OperationRest {
	@Autowired
	private OparationService operationService;
	@Autowired
	private OperationDao  oparationDao;
	/**
	 * @param operation
	 * @return
	 * @see com.example.gestionbacaire.service.facade.OparationService#save(com.example.gestionbacaire.bean.Operation)
	 */
	public int save(Operation operation) {
		return operationService.save(operation);
	}
	/**
	 * @param rib
	 * @return
	 * @throws FileNotFoundException
	 * @throws JRException
	 * @see com.example.gestionbacaire.service.facade.OparationService#exportReport(java.lang.String)
	 */
	public byte[] exportReport(String rib) throws FileNotFoundException, JRException {
		return operationService.exportReport(rib);
	}
	/**
	 * @param compte
	 * @return
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @see com.example.gestionbacaire.service.facade.OparationService#pdfinfo(com.example.gestionbacaire.bean.Compte)
	 */
	@PostMapping("/pdf")
	public int pdfinfo(@RequestBody Compte compte) throws FileNotFoundException, DocumentException {
		return operationService.pdfinfo(compte);
	}
	@Autowired
	private CompteService compteService;
	@GetMapping("/stati/rib/{rib}")
	public List<Double>stati(@PathVariable String rib ){
		return operationService.stati(rib);
	}
	public int crediter(String rib, Long montant) {
		return operationService.crediter(rib, montant);
	}
	
	@GetMapping("/page/rib/{rib}")
	  public Page<Operation> list(@RequestParam(name = "page", defaultValue = "0") int page,
	                                 @RequestParam(name = "size", defaultValue = "5") int size,@PathVariable String rib) {
	    PageRequest pageRequest = PageRequest.of(page, size);
	    Page<Operation> pageResult = oparationDao.findByComptSourceRibOrderByDateDesc(rib, pageRequest);
	    return pageResult;
	  }
	
	public int deleteByComptSourceRib(String rib) {
		return operationService.deleteByComptSourceRib(rib);
	}

	@GetMapping("/report/rib/{rib}")
	
    public byte[]  generateReport(@PathVariable String rib) throws FileNotFoundException, JRException {
		
        return  operationService.exportReport(rib);
    }

	/**
	 * @param rib
	 * @return
	 * @see com.example.gestionbacaire.service.facade.OparationService#deleteByComDis(java.lang.String)
	 */
	public int deleteByComDis(String rib) {
		return operationService.deleteByComDis(rib);
	}

	
	public int delete(Operation operation) {
		return operationService.delete(operation);
	}

	
	public List<Operation> findAll() {
		return operationService.findAll();
	}

	

	@PostMapping("/")
	  @ResponseBody
	public int transfer(@RequestBody Operation operation) {
		return operationService.transfer(operation);
	}
	
    @GetMapping("/c/{c}/duree/{duree}/taux/{taux}")
	public double calculeMensualite(@PathVariable double c,@PathVariable int duree,@PathVariable double taux) {
		return operationService.calculeMensualite(c, duree, taux);
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
		@RequestMapping(value = "/pdfreport/rib/{rib}", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> findByall(@PathVariable String rib){
   Compte c= compteService.findByRib(rib);
	        List<Operation> cities = (List<Operation>) operationService.findByComptSourceRibOrderByDateDesc(rib);

	        ByteArrayInputStream bis = GeneratePdfRepor.citiesReport(cities,rib,c.getSolde());

	        
	        new HttpHeaders().add("Content-Disposition", "inline filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(new HttpHeaders())
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
		
}
