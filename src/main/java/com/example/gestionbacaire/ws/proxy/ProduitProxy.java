package com.example.gestionbacaire.ws.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.gestionbacaire.ws.converter.vo.ProduitVo;
import com.example.gestionbacaire.ws.converter.vo.extange.FactureVo;


@FeignClient(name = "microservice-produit-v4-api", url = "localhost:8091")
public interface ProduitProxy {

    @GetMapping("produit-api/produits/reference/{reference}")
    public ProduitVo findByReference(@PathVariable("reference") String reference);
    @GetMapping("radema/facture/")
	public List<FactureVo> findAll();
    @GetMapping("radema/facture/libelle/{li}")
	public List<FactureVo>nopay(@PathVariable String li);
    @GetMapping("radema/facture/ref/{ref}")
	public FactureVo findByRef(@PathVariable String ref) ;
    @GetMapping("radema/facture/id/{id}")
   	public FactureVo findById(@PathVariable Long id) ;
}
