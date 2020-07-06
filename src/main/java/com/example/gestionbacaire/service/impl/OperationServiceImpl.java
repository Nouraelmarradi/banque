package com.example.gestionbacaire.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gestionbacaire.Dao.CompteDao;
import com.example.gestionbacaire.Dao.OperationDao;
import com.example.gestionbacaire.bean.Compte;
import com.example.gestionbacaire.bean.Operation;
import com.example.gestionbacaire.bean.TypeOperation;
import com.example.gestionbacaire.service.facade.CompteService;
import com.example.gestionbacaire.service.facade.OparationService;
import com.example.gestionbacaire.service.facade.TypeOperationService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class OperationServiceImpl implements OparationService{
	@Autowired
	private OperationDao operationdao;
		@Autowired
	private CompteService compteService;
		@Autowired
		private TypeOperationService typeOperationService;
	@Autowired	
	private CompteDao compteDao;
	@Autowired
    private JavaMailSender sender;
 
		@Override
		public int save(Operation operation) {
			
			if(operation.getTypeOperation().getLibelle().equals("debit")) {
				operation.setTypeOperation(operation.getTypeOperation());	
		debiter(operation.getComptSource().getRib(), operation.getMontant());
		return 1;}
		else if(operation.getTypeOperation().getLibelle().equals("versement"))
		{			operation.setTypeOperation(operation.getTypeOperation());
//transfer(operation.getComptSource().getRib(), operation.getComptDis().getRib(), operation.getMontant());
			
			return 2;
		}	
		else if(operation.getTypeOperation().getLibelle().equals("credit"))	{
			operation.setTypeOperation(operation.getTypeOperation());
		crediter(operation.getComptSource().getRib(),operation.getMontant());
	    
		return 1;
		}
			return -1;
		}
	
			
	@Override
		public int debiter(String rib,Long montant) {
		Compte c =compteService.findByRib(rib);

		if(c==null)return -1;
		else if(c.getSolde()<montant) {
			return -2;
		}else {
			
			c.setSolde(c.getSolde()-montant);
			
			Operation d=new Operation();
			d.setComptSource(c);
			d.setMontant(montant);
			d.setDate(new Date() );
			TypeOperation typeOperation =typeOperationService.findByLibelle("debit");
			d.setTypeOperation(typeOperation);
			operationdao.save(d);
			compteDao.save(c);
			return 1;
		}
		}
	@Override
		public int crediter(String rib,Long montant) {
			Compte c =compteService.findByRib(rib);
			if(c==null)return -1;
				c.setSolde(c.getSolde()+montant);
				Operation o =new Operation(montant, new Date(), c);
				TypeOperation typeOperation =typeOperationService.findByLibelle("credit");
				o.setTypeOperation(typeOperation);
				operationdao.save(o);
				compteDao.save(c);
				return 1;
			}	
		@Override
		public int transfer(Operation operation) {
			Compte c =compteService.findByRib(operation.getComptSource().getRib());
			Compte c1 =compteService.findByRib(operation.getComptDis().getRib());
			if(c==null)return -1;
			if(c1==null)return -2;
			if(c.getSolde()<operation.getMontant()) {return -3;}
			else {
				crediter(c1.getRib(),operation.getMontant());
				debiter(c.getRib(), operation.getMontant());
				TypeOperation typeOperation =typeOperationService.findByLibelle("transfert");
				Operation o= new Operation(operation.getMontant(), new Date(), c);
				o.setComptDis(c1);
				o.setComptSource(c);
				o.setTypeOperation(typeOperation);
				operationdao.save(o);
				try {
		            sendEmail(o.getComptDis().getClient().getEmail(),"Transfert de "+o.getMontant()+" part de  "+o.getComptSource().getClient().getNom() ,"Notification de virement");
		            sendEmail(o.getComptSource().getClient().getEmail(),"Votre transfert d'argent a été bien réceptionné par "+o.getComptDis().getClient().getNom(),"Notification de virement");

		            return 15;
		        }catch(Exception ex) {
		            System.out.println(ex);
		        }
				return 1;
			}
			
		}
		
	
	   
	        
	    
	 
	    private void sendEmail(String email,String text,String sub) throws Exception{
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	         
	        helper.setTo(email);
	        helper.setText(text);
	        helper.setSubject(sub);
	         
	        sender.send(message);
	    }
		@Override
		public Operation findByRef(String ref) {
			// TODO Auto-generated method stub
			return operationdao.findByLibelle(ref);
		}
          @Override
		  public byte[] exportReport(String rib) throws FileNotFoundException, JRException {
		     String path = "C:\\Users\\HP\\Desktop\\PFE";
	        List<Operation> employees = operationdao.findByComptSourceRib(rib);
	        Compte c= compteService.findByRib(rib);
		        //load file and compile it
		        File file = ResourceUtils.getFile("classpath:employees2.jrxml");
		        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		        Map<String, Object> parameters = new HashMap<>();
		        parameters.put("createdBy", "Java Techie");
		        parameters.put("rib","rib"+"  "+rib);
		        parameters.put("solde", ""+c.getSolde());
		        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		       
		        
		            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");

		        

		        return 		            JasperExportManager.exportReportToPdf(jasperPrint);
 
		    }
		
		
   
		@Override
		public List<Operation> findByComptSourceRibOrderByDateDesc(String rib) {
			List<Operation> ops= operationdao.doit(rib);
			List<Operation> opss=new ArrayList<Operation>();
			
			for(int i=0;i<ops.size();i++) {
				int b=ops.size();
				System.out.println(b);
				Date d=	ops.get(0).getDate();
				System.out.println(d);
			Date d2=	ops.get(i).getDate();
			long dif=d.getTime()-d2.getTime();
			long yes=TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
				if(yes<60) {
					opss.add(ops.get(i));
				}
			}
			System.out.println();
			return opss;
		}

		@Override
		public String instance(String ref) {
			// TODO Auto-generated method stub
			Operation o=findByRef(ref);
			
			return "Debit";
			
		}

		@Override
		public double calculeMensualite(double c, int duree , double taux) {
			double t=taux/100;
			double t1=c*t/12;
			double t2=Math.pow(1+t/12,-1*duree);
			double t3=1-t2;
			return t1/t3;
		}

        @Transactional
		@Override
		public int deleteByComptSourceRib(String rib) { 
			// TODO Auto-generated method stub
			return operationdao.deleteByComptSourceRib(rib);
		}
     @Transactional
		@Override
		public int deleteByComDis(String rib) {
			return operationdao.deleteByComptDis(rib);
		}
     
     @Override
     public int pdfinfo(Compte compte)throws FileNotFoundException,DocumentException{
    	 Document document = new Document();
    	 DateFormat date= DateFormat.getDateTimeInstance(
    				DateFormat.SHORT,DateFormat.SHORT
    				);
    	 List<Operation>ops=operationdao.findByComptSourceRib(compte.getRib());
    	 PdfWriter.getInstance(document, new FileOutputStream("PDF"));
    	 document.open();
    	 System.out.println("open");
         Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
         Font font2 = FontFactory.getFont(FontFactory.  HELVETICA_BOLD, 14, BaseColor.BLACK);
         Paragraph para = new Paragraph( "BANQUE EN LIGNE", font2);
         Paragraph para1 = new Paragraph( "  ", font);
         Paragraph para2 = new Paragraph("Date"+"         " , font);
         Paragraph para3 = new Paragraph( "  ", font);
         Paragraph para4 = new Paragraph( " EXTRAIT DES OPERATIONS  ", font);
         Paragraph para5 = new Paragraph(""+date.format(new Date()), font);
         Paragraph para6= new Paragraph( "Rib   :"+" "  +compte.getRib(), font);
         Paragraph para8= new Paragraph( "AU"+"  "+" "+" "+" :"+date.format(new Date()), font);
         Paragraph para7= new Paragraph( "SOLDE"+"  :"+"MAD" +compte.getSolde(), font);
         Paragraph espa= new Paragraph("      ",font);
         Paragraph espa1= new Paragraph("Ministre de maroco so  ",font);
         para.setAlignment(Element.ALIGN_CENTER);
         para4.setAlignment(Element.ALIGN_CENTER);
         espa1.setAlignment(Element.ALIGN_TOP);
        espa1.setAlignment(Element.ALIGN_LEFT);
       
         para2.setAlignment(Element.ALIGN_JUSTIFIED);
         

             PdfPTable table = new PdfPTable(3);
             table.setWidthPercentage(60);
             table.setWidths(new int[]{2, 3, 3});
             Font headFont = FontFactory.getFont(FontFactory.COURIER);

             PdfPCell hcell;
             
             hcell = new PdfPCell(new Phrase("mantant", headFont));
             hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table.addCell(hcell);

          

             
             hcell = new PdfPCell(new Phrase("OperationLibelle", headFont));
             hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table.addCell(hcell);

             hcell = new PdfPCell(new Phrase("date", headFont));
             hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
             table.addCell(hcell);
             
             for (Operation city : ops) {

                 PdfPCell cell;

                

                 cell = new PdfPCell(new Phrase(city.getMontant().toString()));
                 cell.setPaddingLeft(5);
                 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                 table.addCell(cell);

                 
                 cell = new PdfPCell(new Phrase(String.valueOf(city.getTypeOperation().getLibelle())));
                 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 cell.setPaddingRight(5);
                 table.addCell(cell);
                 cell = new PdfPCell(new Phrase(city.getDate().toString()));
                 cell.setPaddingLeft(5);
                 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                 cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                 table.addCell(cell);

             }

            
             document.open();
             document.add(espa1);
             document.add(para);
             document.add(para1);
             document.add(para2);
             document.add(para5);
             document.add(para3);
             document.add(para4);
             document.add(espa);
             document.add(para6);
             
             document.add(espa);
             document.add(table);
             document.add(para8);
             document.add(para7);
 			document.add(Chunk.NEWLINE);
 			document.addTitle("relve de compte");
             document.close();
        return 1;}
     @Override
public List<Double>stati(String rib ){
    	 Compte comp=compteService.findByRib(rib);
    	 if(comp==null) {return null;}
    	 else {
List<Operation>o=operationdao.findByComptSourceRib(comp.getRib());
System.out.println(o);
System.out.println(rib);
List<Double>os=new ArrayList<Double>();
double s=0;
double m=0;
for (int i = 0; i < o.size(); i++) {
	if(o.get(i).getTypeOperation().getLibelle().equals("debit")) {
	s=s+o.get(i).getMontant();
	System.out.println(s);
	}
	if(o.get(i).getTypeOperation().getLibelle().equals("credit")) {
		m=m+o.get(i).getMontant();
		System.out.println(m);
		}}
System.out.println(m);

System.out.println(s);

os.add(s);
os.add(m);
System.out.println(os);
return os;}
}

	@Override
	@Transactional
	public int delete(Operation operation) {
		Operation op = operationdao.findById(operation.getId()).get();
		if(op == null){
			return -1;
		}else {
			operationdao.delete(op);
			return 1;
		}
		
	}


	@Override
	public List<Operation> findAll() {
		// TODO Auto-generated method stub
		return operationdao.findAll();
	}


	
}
