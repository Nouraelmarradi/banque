package com.example.gestionbacaire.service.facade;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Operation;
import com.itextpdf.text.DocumentException;

import net.sf.jasperreports.engine.JRException;

public interface OparationService {
Operation  findByRef(String ref);
int save(Operation operation);
public int debiter(String rib,Long montant) ;
List<Operation> findByComptSourceRibOrderByDateDesc(String rib);
String instance(String ref);
int crediter(String rib, Long montant);
int transfer(Operation operation);
int deleteByComptSourceRib(String rib);
int deleteByComDis(String rib);
int delete(Operation operation);
List<Operation> findAll();
double calculeMensualite(double c, int duree, double taux);
public byte[] exportReport(String rib) throws FileNotFoundException, JRException;
List<Double> stati(String rib);
int pdfinfo(Compte compte) throws FileNotFoundException, DocumentException;

}
