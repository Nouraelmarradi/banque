package com.example.gestionbacaire.service.facade;

import com.example.gestionbacaire.bean.TypeFacture;

public interface TypeFactureService {
	public TypeFacture findByLibelle(String libelle);
    public int save(TypeFacture typeFacture);
}
