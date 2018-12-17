package com.alighthub.employeepayrollservice.serviceimpli;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.alighthub.employeepayrollservice.common.GenrateSalarySlipUser;
import com.alighthub.employeepayrollservice.dao.EmployeePayRollServiceUserDao;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.MonthlySalaryGenrate;

import com.alighthub.employeepayrollservice.model.UserRegistration;
import com.alighthub.employeepayrollservice.service.EmployeePayRollServiceUserService;



@Service
public class EmployeePayRollServiceUserServiceImpli implements EmployeePayRollServiceUserService {
	
	@Autowired
	private EmployeePayRollServiceUserDao userpayslipservice;
	
	@Autowired
    public JavaMailSender emailSender;
	
	MonthlySalaryGenrate payslip;


//==========================================payslip menu=========================================================//
	@Override
	public MonthlySalaryGenrate paySlipPost(MonthlySalaryGenrate monthlySalaryGenrate) {
		payslip= userpayslipservice.paySlipPost(monthlySalaryGenrate);
	//==========================create object of pay slip and call method of payslip======================//
		GenrateSalarySlipUser genratepdf=new GenrateSalarySlipUser();
		genratepdf.createPDF(payslip);
	//============================call sendEmail method for sending payslip email to user=================//
		try {
			sendEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return payslip;
	}
	
//======================================================================================================================//
	
	
//==============================================personal details menu===================================================//
	
	@Override
	public UserRegistration userPersonalDatails(Integer userrid) {
		UserRegistration upd1= userpayslipservice.userPersonalDatails(userrid);
		
		return upd1;
	}
//======================================================================================================================//

//===========================================mail send code=============================================================//
	
	
	private void sendEmail() throws Exception {
	 MimeMessage message = emailSender.createMimeMessage();
     boolean multipart = true;
	 MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
	//static
	// helper.setTo("kumbharniranjan@gmail.com");	  
	//dynamic 
	helper.setTo(payslip.getUserRegistration().getUserEmail());
     helper.setSubject("Test email with attachments");
     helper.setText("Hello, Im testing email with attachments!");
     String path1 = "E:/"+payslip.getUserRegistration().getUserFirstName()+""+payslip.getMonth()+".pdf";
     System.out.println("file path --------------------"+path1);
     // Attachment 1
     FileSystemResource file1 = new FileSystemResource(new File(path1));
     System.out.println("file name in mail ----------------------"+file1.getFilename());
     
     //helper.addAttachment(payslip.getUser().getUserFirstName()+""+payslip.getMonth(), file1);
     helper.addAttachment(file1.getFilename(), file1);
    emailSender.send(message);
	}
	
//===================================================POST===================================================================//
	@Override
	public int changepassword(Login login) {
		// TODO Auto-generated method stub
	int list=	userpayslipservice.changepassword(login);
	return list;
		
	}
//===================================================GET====================================================================//

@Override
public boolean getpassword1(String password) {
	
	//userpayslipservice.getpassword1(password);
	if(userpayslipservice.getpassword1(password))
	{
		return true;
	}
	else
	{
		return false;
	}
	
	
}
	
}
