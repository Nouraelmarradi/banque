package com.example.gestionbacaire.service.facade;

import java.util.List;

import com.example.gestionbacaire.bean.Operation;

public interface OparationService {
Operation  findByRef(String ref);
int save(Operation operation);
public int debiter(String rib,Long montant) ;
List<Operation> findByComptSourceRibOrderByDateDesc(String rib);
String instance(String ref);
public double calculeMensualite(double c,int duree);
int crediter(String rib, Long montant);
int transfer(String ribsource, String ribdestination, Long montant);
int deleteByComptSourceRib(String rib);
int deleteByComDis(String rib);

}
