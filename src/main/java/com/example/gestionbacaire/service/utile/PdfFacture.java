package com.example.gestionbacaire.service.utile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.gestionbacaire.bean.Operation;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfFacture {
	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfRepor.class);
	public static	DateFormat date= DateFormat.getDateTimeInstance(
			DateFormat.SHORT,DateFormat.SHORT
			);
	    public static ByteArrayInputStream citiesReport( String rib, double solde,Long num) {
	   
	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        
	        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
	        Font font2 = FontFactory.getFont(FontFactory.  HELVETICA_BOLD, 14, BaseColor.BLACK);
	        Paragraph releve = new Paragraph("BANQUE EN LIGNE"+"                                                                "+"Payement de Facture", font2);
	        Paragraph para0 = new Paragraph( "Service en ligne                "+"du "+date.format(new Date()), font);
	        Paragraph para1 = new Paragraph( "  ", font);
	        Paragraph para3 = new Paragraph( "  ", font);
	        Paragraph para4 = new Paragraph( " Payement de facture N° : " + solde, font);
	        Paragraph para5 = new Paragraph(""+date.format(new Date()), font);
	        Paragraph para6= new Paragraph( "Rib :"+rib, font);
	        Paragraph para8= new Paragraph( "AU"+"  "+" "+" "+" :"+date.format(new Date()), font);
	        Paragraph para7= new Paragraph( "Mantant de facture"+"  :" +num+ " "+"MAD", font);
	        Paragraph espa= new Paragraph("      ",font);
	        Paragraph espa1= new Paragraph("",font);
	        para4.setAlignment(Element.ALIGN_CENTER);
	        espa1.setAlignment(Element.ALIGN_TOP);
	       espa1.setAlignment(Element.ALIGN_LEFT);
	       releve.setAlignment(Element.ALIGN_RIGHT);
	       releve.setAlignment(Element.ALIGN_TOP);
	      

	        try {

	            PdfPTable table = new PdfPTable(3);
	            table.setWidthPercentage(90);
	            
	            table.setWidths(new int[]{2, 4, 3});
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
	            
	           

	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(releve);
	            document.add(para0);
	            document.add(para1);
	           
	            document.add(para1);
	            document.add(para3);
	            document.add(para4);
	            document.add(espa);
	            document.add(para6);
	            document.add(espa);
	            document.add(para8);
	            document.add(para7);
				document.add(Chunk.NEWLINE);
				document.addTitle("Payement de facture");
	            document.close();

	        } catch (DocumentException ex) {

	            logger.error("Error occurred: {0}", ex);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
}
