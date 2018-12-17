package com.alighthub.employeepayrollservice.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.alighthub.employeepayrollservice.model.MonthlySalaryGenrate;
import com.itextpdf.text.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GenrateSalarySlipUser {
	
	
	
	private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;
    
	 public  void createPDF (MonthlySalaryGenrate s)
	 {
		 
		 String pdfFilename=s.getUserRegistration().getUserFirstName()+""+s.getMonth()+".pdf";
		 System.out.println(pdfFilename);
	    	Document doc = new Document();
	    	
	    	PdfWriter docWriter = null;
	    	initializeFonts();
	    	try
	    	{
	    		String path = "E:/"+pdfFilename;
	//==================================================================================================//  
	    		

	 //================================================================================================//   		
	    		//String path ="virendra.engole27@gmail.com"+pdfFilename;
	    		docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
	 
	 //===================================================================================================//   		
//	    		PdfWriter writer=docWriter;
//	    		
	    		String USER_PASSWORD = s.getUserRegistration().getUserFirstName();
	    		String OWNER_PASSWORD = s.getUserRegistration().getUserLastName();
//	    		
	    		docWriter.setEncryption(
	    		        USER_PASSWORD.getBytes(),
	    		        OWNER_PASSWORD.getBytes(),
	    		        PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING,
	    		        PdfWriter.ENCRYPTION_AES_256 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
	    	//	docWriter.createXmpMetadata();
	  //===================================================================================================//  		
	    		
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
	    				generateLayout(doc, cb,s); 
	    				generateHeader(doc, cb,s);
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
	    
	    private void generateLayout(Document doc, PdfContentByte cb,MonthlySalaryGenrate s)
	    {
	    	
	    	try
	    	{
	    		cb.setLineWidth(1f);
	    		
	    		// Invoice Header box layout
	    		/*cb.rectangle(420,700,150,60);
	    		cb.moveTo(420,720);
	    		cb.lineTo(570,720);
	    		cb.moveTo(420,740);
	    		cb.lineTo(570,740);
	    		cb.moveTo(480,700);
	    		cb.lineTo(480,760);
	    		cb.stroke();*/
	    		
	    		// Invoice Header box Text Headings 
	    		/*createHeadings(cb,422,743,"Account No.");
	    		createHeadings(cb,422,723,"Invoice No.");
	    		createHeadings(cb,422,703,"Invoice Date");
	*/
	    		// Payment Detail Box
	    		//cb.rectangle(20,50,550,600);
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
	    	/*	cb.moveTo(500,50);
	    		cb.lineTo(500,650);*/
	    		cb.stroke();
	    		
	    		// Payment Text Headings 
	    		createHeadings(cb,70,633,"Earnings");
	    		createHeadings(cb,195,633,"Amount");
	    		createHeadings(cb,350,633,"Deduction");
	    		createHeadings(cb,480,633,"Amount");
	    		createHeadings(cb,70,417,"Total");
	    		createHeadings(cb,350,417,"Total");

	    		
	    		createHeadings(cb,25,617,"BASIC");
	    		createHeadings(cb,25,602,"HOUSE RENT ALLOWNCE");
	            createHeadings(cb,25,587,"DA");
	    		createHeadings(cb,25,572,"TA");
	    		createHeadings(cb,25,557,"PF");
	    		createHeadings(cb,310,617,"LIC");
	    		createHeadings(cb,310,602,"PT");
	    		createHeadings(cb,310,587,"RD");
	    		createHeadings(cb,310,572,"INCOME TAX");

	    		createHeadings(cb,195,617,s.toString().valueOf(s.getUserRegistration().getBasicSalary()));
	    		createHeadings(cb,195,602,s.toString().valueOf(s.getHRA()));
	    		createHeadings(cb,195,587,s.toString().valueOf(s.getDA()));
	    		createHeadings(cb,195,572,s.toString().valueOf(s.getTA()));
	    		createHeadings(cb,195,557,s.toString().valueOf(s.getPF()));
	    		createHeadings(cb,480,617,s.toString().valueOf(s.getLIC()));
	    		createHeadings(cb,480,602,s.toString().valueOf(s.getPT()));
	    		createHeadings(cb,480,587,s.toString().valueOf(s.getRD()));
	    		createHeadings(cb,480,572,"3000");
	    		createHeadings(cb,195,417,s.toString().valueOf(s.getUserRegistration().getBasicSalary()+s.getDA()+s.getTA()+s.getPF()+s.getHRA()));
	    		createHeadings(cb,480,417,s.toString().valueOf(s.getLIC()+s.getPT()+s.getRD()+s.getIncomeTax()));

	    		createHeadings(cb,30,387,"NET PAY");
	    		createHeadings(cb,150,387,s.toString().valueOf(s.getNetSalary()));
	    		createHeadings(cb,30,372,"IN WORDS");
	    		
	 //===============================================================================================//   		
	    		
				createHeadings(cb,150,372,convert((int) s.getNetSalary()));
	    		createHeadings(cb,175,357,"This is computer generated payslip signature not required.");
	    		
	    		
	    		
	    		//createHeadings(cb,502,633,"Ext Price");
	    		
	    		//add the images
	    		//Image companyLogo = Image.getInstance("logo.jpg");
//	    		companyLogo.setAbsolutePosition(25,720);
//	    		companyLogo.scalePercent(35);
//	    		doc.add(companyLogo);
	    	}	
//	    	catch(DocumentException dex)
//	    	{
//	    		dex.printStackTrace();
//	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	    	
	    }
	    
	    //=============================convert numric to words=========================================================//
	    public static final String[] units = { "", "One", "Two", "Three", "Four",
	    		"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
	    		"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
	    		"Eighteen", "Nineteen" };

	    		public static final String[] tens = { 
	    		        "",         // 0
	    		        "",     // 1
	    		        "Twenty",   // 2
	    		        "Thirty",   // 3
	    		        "Forty",    // 4
	    		        "Fifty",    // 5
	    		        "Sixty",    // 6
	    		        "Seventy",  // 7
	    		        "Eighty",   // 8
	    		        "Ninety"    // 9
	    		};

	    		public static String convert(final int n) {
	    		    if (n < 0) {
	    		        return "Minus " + convert(-n);
	    		    }

	    		    if (n < 20) {
	    		        return units[n];
	    		    }

	    		    if (n < 100) {
	    		        return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
	    		    }

	    		    if (n < 1000) {
	    		        return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
	    		    }

	    		    if (n < 100000) {
	    		        return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
	    		    }

	    		    if (n < 10000000) {
	    		        return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
	    		    }

	    		    return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	    		}

	    //======================================================================================//
    
	    private void generateHeader(Document doc, PdfContentByte cb,MonthlySalaryGenrate s)
	    {
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	        Date date = new Date();  
	        System.out.println(formatter.format(date));
	        String dt=formatter.format(date);
	    	try
	    	{
	    		
	    	
	    		createHeadings1(cb,250,750,"Alight Hub");
	    		createHeadings(cb,170,735,"Babamuni Ashram Road, Walhekarwadi, Akurdi, Pune-33, Maharashtra ");
	    		createHeadings(cb,230,720,"Salary Slip for the month of "+s.getMonth()+" "+s.getYear());
	    		createHeadings(cb,20,690,"Employee Name");
	    		createHeadings(cb,130,690,s.getUserRegistration().getUserFirstName()+" "+s.getUserRegistration().getUserLastName());
	    		createHeadings(cb,20,675,"Employee Id");
	    		createHeadings(cb,130,675,"ALI101");
	    		createHeadings(cb,20,660,"Employee Designation");
	    		createHeadings(cb,130,660,s.getUserRegistration().getDesignation());
	    		
	    		createHeadings(cb,400,690,"A/C No. ");
	    		createHeadings(cb,470,690,"1234567890");
	    		createHeadings(cb,400,675,"NOD ");
	    		createHeadings(cb,470,675,"25");
	    		createHeadings(cb,400,660,"Department ");
	    		createHeadings(cb,470,660,s.getUserRegistration().getDepartment());

	    			
	    		


	    		
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}	
	    
	    }
	   /* 
	    private void generateDetail(Document doc, PdfContentByte cb, int index, int y)
	    {
	    	DecimalFormat df = new DecimalFormat("0.00");
	    	try
	    	{
	    		createContent(cb,48,y,String.valueOf(index+1),PdfContentByte.ALIGN_RIGHT);
	    		createContent(cb,52,y, "ITEM" + String.valueOf(index+1),PdfContentByte.ALIGN_LEFT);
	    		createContent(cb,152,y, "Product Description - SIZE " + String.valueOf(index+1),PdfContentByte.ALIGN_LEFT);
	    		
	    		double price = Double.valueOf(df.format(Math.random() * 10));
	    		double extPrice = price * (index+1) ;
	    		createContent(cb,498,y, df.format(price),PdfContentByte.ALIGN_RIGHT);
	    		//createContent(cb,568,y, df.format(extPrice),PdfContentByte.ALIGN_RIGHT);
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	    }
	*/
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
