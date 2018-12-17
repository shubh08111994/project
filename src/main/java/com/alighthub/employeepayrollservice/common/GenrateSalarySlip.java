package com.alighthub.employeepayrollservice.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alighthub.employeepayrollservice.model.SalarySlipStructure;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GenrateSalarySlip {
	
	
	private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;
    
	 public  void createPDF (SalarySlipStructure slip)
	    {
		 
		 String pdfFilename="invoice.pdf";
	    	Document doc = new Document();
	    	PdfWriter docWriter = null;
	    	initializeFonts();
	    	try
	    	{
	    		String path = "E:/"+pdfFilename;
	    		docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
	    		doc.addAuthor("betterThanZero");
	    		doc.addCreationDate();
	    		doc.addProducer();
	    		doc.addCreator("MySampleCode.com");
	    		doc.addTitle("Invoice");
	    		doc.setPageSize(PageSize.LETTER);
	    		doc.open();
	    		PdfContentByte cb = docWriter.getDirectContent();
	    		boolean beginPage = true;
	    		int y=0;
	    		
	    		for(int i=0;i<8;i++)
	    		{
	    			if(beginPage)
	    			{
	    				beginPage = false;
	    				generateLayout(doc, cb,slip); 
	    				generateHeader(doc, cb,slip);
	    				y=615; 
	    			}
	    			//generateDetail(doc, cb, i, y);
	    			y=y-15;
	    			if(y<50)
	    			{
	    				printPageNumber(cb);
	    				doc.newPage();
	    				beginPage = true;
	    			}
	    		}
	    		printPageNumber(cb);	
	    	}
	    	catch (DocumentException dex)
	    	{
	    		dex.printStackTrace();
	    	}	
	    	catch (Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	    	finally
	    	{
	    		if(doc != null)
	    		{
	    			doc.close();
	    		}
	    		if(docWriter != null)
	    		{
	    			docWriter.close();
	    		}
	    	}
	    }
	    
	    private void generateLayout(Document doc, PdfContentByte cb,SalarySlipStructure slip)
	    {
	    	try
	    	{
	    		cb.setLineWidth(1f);
	    		
	    		
	    		cb.rectangle(20,352,550,298);
	    		
	    		cb.moveTo(20,630);
	    		cb.lineTo(570,630);
	    		cb.moveTo(20,430);
	    		cb.lineTo(570,430);
	    		cb.moveTo(20,405);
	    		cb.lineTo(570,405);
	    		cb.moveTo(150,405);
	    		cb.lineTo(150,650);
	    		cb.moveTo(300,405);
	    		cb.lineTo(300,650);
	    		cb.moveTo(450,405);
	    		cb.lineTo(450,650);
	    	
	    		cb.stroke();
	    		
	    		// Payment Text Headings 
	    		createHeadings(cb,70,633,"Earnings");
	    		createHeadings(cb,195,633,"Amount");
	    		createHeadings(cb,350,633,"Deduction");
	    		createHeadings(cb,480,633,"Amount");
	    		
	    		createHeadings(cb,70,417,"Gross Salary");
	    		createHeadings(cb,195,417,slip.toString().valueOf(slip.getGrossSalary()));

	    		createHeadings(cb,350,417,"Total");
	    		createHeadings(cb,480,417,slip.toString().valueOf(slip.getTotalDeduction()));
	    		
	    		createHeadings(cb,25,617,"BASIC");
	    		createHeadings(cb,195,617,slip.toString().valueOf(slip.getBasicSalary()));

	    		createHeadings(cb,25,602,"DA");
	    		createHeadings(cb,195,602,slip.toString().valueOf(slip.getDA()));
	    		
	    		createHeadings(cb,25,587,"HRA");
	    		createHeadings(cb,195,587,slip.toString().valueOf(slip.getHRA()));

	    		createHeadings(cb,25,572,"TA");
	    		createHeadings(cb,195,572,slip.toString().valueOf(slip.getTA()));

	    		createHeadings(cb,25,557,"Grad Pay");
	    		createHeadings(cb,195,557,slip.toString().valueOf(slip.getGradePay()));
	    		
//	    		createHeadings(cb,25,557,"BONUS");
//	    		createHeadings(cb,195,557,"2000");
	    		
	    		createHeadings(cb,310,617,"PF");
	    		createHeadings(cb,480,617,slip.toString().valueOf(slip.getPF()));

	    		createHeadings(cb,310,602,"INSURANCE");
	    		createHeadings(cb,480,602,slip.toString().valueOf(slip.getInsurance()));

	    		createHeadings(cb,310,587,"RD");
	    		createHeadings(cb,480,587,slip.toString().valueOf(slip.getRD()));

	    		createHeadings(cb,310,572,"PT");
	    		createHeadings(cb,480,572,slip.toString().valueOf(slip.getPT()));

	    		createHeadings(cb,310,557,"LIC");
	    		createHeadings(cb,480,557,slip.toString().valueOf(slip.getLIC()));

	    		createHeadings(cb,310,542,"Income-Tax");
	    		createHeadings(cb,480,542,slip.toString().valueOf(slip.getIncomeTax()));
	    		
	    		createHeadings(cb,30,387,"NET PAY");
	    		createHeadings(cb,150,387,slip.toString().valueOf(slip.getNetSalary()));
	    			    		
	    		createHeadings(cb,30,372,"IN WORDS");
	    		createHeadings(cb,150,372,"TWENTY SIX THOUSAND ONLY");
	    		createHeadings(cb,175,357,"This is computer generated payslip signature not required.");
	    		
	    		



	    		
	    		
	    		//add the images
	    		Image companyLogo = Image.getInstance("logo.jpg");
	    		companyLogo.setAbsolutePosition(25,720);
	    		companyLogo.scalePercent(35);
	    		doc.add(companyLogo);
	    	}	
	    	catch(DocumentException dex)
	    	{
	    		dex.printStackTrace();
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	    }
	    
	    private void generateHeader(Document doc, PdfContentByte cb,SalarySlipStructure slip)
	    {
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	        Date date = new Date();  
	        System.out.println(formatter.format(date));
	        String dt=formatter.format(date);
	    	try
	    	{
	    		
//	    		createHeadings1(cb,250,750,f.getComname());
	    		createHeadings1(cb,250,750,"MyCompany");
	    		createHeadings(cb,170,735,"Babamuni Ashram Road, Walhekarwadi, Akurdi, Pune-33, Maharashtra ");
	    		createHeadings(cb,230,720,"Salary Slip for the month of Dec/2017");
	    		createHeadings(cb,20,690,"Employee Name");
	    		createHeadings(cb,130,690,slip.getEmployeeRegistration().getEmployeeFirstName());
	    		createHeadings(cb,20,675,"Employee Id");
	    		createHeadings(cb,130,675,slip.toString().valueOf(slip.getEmployeeRegistration().getEmployeeId()));
	    		createHeadings(cb,20,660,"Employee Designation");
	    		createHeadings(cb,130,660,slip.getEmployeeRegistration().getDesignation());
	    		
	    		createHeadings(cb,400,690,"A/C No. ");
	    		createHeadings(cb,470,690,"1234567890");
	    		createHeadings(cb,400,675,"NOD ");
	    		createHeadings(cb,470,675,"25");
	    		createHeadings(cb,400,660,"Department ");
	    		createHeadings(cb,470,660,"Accountant");

	    			
	    		


	    		
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}	
	    
	    }
	 
	    private void createHeadings(PdfContentByte cb, float x, float y, String text)
	    {
	    	cb.beginText();
	    	cb.setFontAndSize(bfBold, 8);
	    	cb.setTextMatrix(x,y);
	    	cb.showText(text.trim());
	    	cb.endText(); 
	    }
	    private void createHeadings1(PdfContentByte cb, float x, float y, String text)
	    {
	    	cb.beginText();
	    	cb.setFontAndSize(bfBold, 12);
	    	cb.setTextMatrix(x,y);
	    	cb.showText(text.trim());
	    	cb.endText(); 
	    }
	    
	    private void printPageNumber(PdfContentByte cb)
	    {
	    	cb.beginText();
	    	cb.setFontAndSize(bfBold, 8);
	    	cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber+1), 570 , 25, 0);
	    	cb.endText(); 
	    	pageNumber++;
	    }
	    
	    private void createContent(PdfContentByte cb, float x, float y, String text, int align)
	    {
	    	cb.beginText();
	    	cb.setFontAndSize(bf, 8);
	    	cb.showTextAligned(align, text.trim(), x , y, 0);
	    	cb.endText(); 
	    }
	    
	    private void initializeFonts()
	    {
	    	try
	    	{
	    		bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	    		bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	    	}
	    	catch (DocumentException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	catch (IOException e)
	    	{
	    		e.printStackTrace();
	    	}
	    }

}
