package com.example.gestionbacaire.ws;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionbacaire.Dao.ClientDao;
import com.example.gestionbacaire.Dao.RoleRepository;
import com.example.gestionbacaire.Dao.UserRepository;
import com.example.gestionbacaire.bean.Client;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.securite.request.response.JwtResponse;
import com.example.gestionbacaire.service.facade.ClientService;
import com.example.gestionbacaire.service.impl.UserDetailsImpl;

@RestController
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping("gestionbancaire/client")
public class ClientRest {
	@Autowired
private ClientService clientService;
	/**
	 * @param pass
	 * @param ct
	 * @return
	 * @see com.example.gestionbacaire.service.facade.ClientService#verifier(java.lang.String, com.example.gestionbacaire.bean.Client)
	 */
	@PostMapping("/pass/{pass}")
	public int verifier(@PathVariable String pass,@RequestBody Client ct) {
		return clientService.verifier(pass, ct);
	}
@PutMapping("/update")
public int uppdate(@RequestBody Client client) {
	return clientService.uppdate(client);
}
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
	@Autowired
	com.example.gestionbacaire.securite.security.jwt.JwtUtils jwtUtils;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private ClientDao clientDao;
	@GetMapping("/")	
	public List<Client> findAll() {
		return clientService.findAll();
	}
	@PutMapping("/verfierviaGamil")
	public int	verigfy(@RequestBody Compte c) {
		return clientService.verigfy(c);
	}
	@PostMapping("/verfierviaGamil")
	public int	verigy(@RequestBody Compte c) {
		return clientService.verigfy(c);
	}
	@GetMapping("/demmande")	
	int demmande(@RequestBody Compte c) {
		return clientService.demmande(c);
	}

	@PutMapping("/registre")
	public	int registre(@RequestBody Client client) {
		return clientService.registre(client);
	}
	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return clientService.deleteByCin(cin);
	}
	@GetMapping("/clientUserm/{username}")
	public Client findByUserUsername(@PathVariable String username) {
		// TODO Auto-generated method stub
		return clientDao.findByUserUsername(username);
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	  public Page<Client> list(@RequestParam(name = "page", defaultValue = "0") int page,
	                                 @RequestParam(name = "size", defaultValue = "10") int size) {
	    PageRequest pageRequest = PageRequest.of(page, size);
	    Page<Client> pageResult = clientDao.findAll(pageRequest);
	    return pageResult;
	 
	  }
	@PostMapping("/save")
	public int savev2(@RequestBody Client client) {
		return clientService.savev2(client);
	}
	@GetMapping("/cin/{cin}")
	public Client findByCin(@PathVariable String cin) {
		return clientService.findByCin(cin);
	}
	
	@GetMapping("/username/{username}")
	public Client findByUsername(@PathVariable String username) {
		return clientService.findByUsername(username);
	}

	
	@GetMapping("/login/username/{username}/passwold/{passwed}")
	public int 	login(@PathVariable String username,@PathVariable String passwed) {
		return clientService.login(username, passwed);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Client client) {
		return clientService.save(client);
	}
	
}
