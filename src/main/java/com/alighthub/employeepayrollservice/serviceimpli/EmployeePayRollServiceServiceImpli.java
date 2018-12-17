package com.alighthub.employeepayrollservice.serviceimpli;



import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.alighthub.employeepayrollservice.common.GenrateSalarySlip;
import com.alighthub.employeepayrollservice.dao.EmployeePayRollServiceDao;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.SalarySlipStructure;
import com.alighthub.employeepayrollservice.model.AdminRegistration;
import com.alighthub.employeepayrollservice.model.EmployeeRegistration;
import com.alighthub.employeepayrollservice.service.EmployeePayRollserviceService;

import freemarker.template.Configuration;
import freemarker.template.Template;
@Service
public class EmployeePayRollServiceServiceImpli implements EmployeePayRollserviceService{
    //invoicepdf
	
	@Autowired
	private EmployeePayRollServiceDao  employeePayRollServiceDao;
	
	@Autowired
	public JavaMailSender emailsend;
	
	@Autowired
	private Configuration fremakcon;
	
	@Override
	public Login checkLogin(Login login) {
		
		Login list=employeePayRollServiceDao.checkLogin(login);
		return list;
	}

	@Override
	public void RegisterCheck(AdminRegistration newAdminRegistration) {
		Login log = new Login();
		log.setLogin_roll(101);
		log.setLogin_pass("admin@123");
		log.setAdminRegistration(newAdminRegistration);
		newAdminRegistration.setLogin(log);
		employeePayRollServiceDao.adminRegisterCheck(newAdminRegistration);		
	}

	
	//Pay roll system (salary slip with employee registration)
	@Override
	public void employeeRegistration(EmployeeRegistration employeeRegistration) {
		
		Login log = new Login();
		SalarySlipStructure salarySlipStructure = new SalarySlipStructure();
		log.setLogin_roll(102);
		log.setLogin_pass("employee@123");
		log.setEmployeeRegistration(employeeRegistration);
		employeeRegistration.setLogin(log);
		
		salarySlip(employeeRegistration,salarySlipStructure);
		
		employeePayRollServiceDao.employeeRegistration(employeeRegistration,salarySlipStructure);
		
	}

	public void salarySlip(EmployeeRegistration employeeRegistration,SalarySlipStructure salarySlipStructure)
	{
		//Salary Structure
		
				double gradPay;
				double da;
				double hra;
				double ta=800;
				double incometax = 2000;
				double pt = 200;
				double lic = 500;
				double rd = 500;
				double insurance = 1000;
				double grossSalary;
				double netSalary;
				
				gradPay = employeeRegistration.getBasicSalary()*40/100;

				salarySlipStructure.setBasicSalary(employeeRegistration.getBasicSalary());
				double gb = gradPay+salarySlipStructure.getBasicSalary();
				salarySlipStructure.setGradePay(gradPay);
				da = gb*142/100;
				salarySlipStructure.setDA(da);
				hra = gb*10/100;
				salarySlipStructure.setHRA(hra);
				
				grossSalary = gb+da+hra+ta;
				
				salarySlipStructure.setGrossSalary(grossSalary);
				
				// Deduction
				double pf = employeeRegistration.getBasicSalary()*12/100;
				salarySlipStructure.setPF(pf);
				salarySlipStructure.setIncomeTax(incometax);
				salarySlipStructure.setPT(pt);
				salarySlipStructure.setLIC(lic);
				salarySlipStructure.setRD(rd);
				salarySlipStructure.setInsurance(insurance);
				salarySlipStructure.setTA(ta);
				double deduction = incometax+pt+lic+rd+pf+insurance;
				salarySlipStructure.setTotalDeduction(deduction);
				netSalary = grossSalary-deduction;
				
				salarySlipStructure.setNetSalary(netSalary);	
				employeeRegistration.setEmployeePackage(grossSalary*12);
				
				salarySlipStructure.setEmployeeRegistration(employeeRegistration);
				//employeeRegistration.setSalarySlipStructure(salarySlipStructure);

	}
	@Override
	public SalarySlipStructure employeSalaryStructure(int id) {
		
		System.out.println("**********************************************************Service");
		SalarySlipStructure slip = employeePayRollServiceDao.employeSalaryStructure(id);
		System.out.println("***********************************************************PDF");
		GenrateSalarySlip generatepdf = new GenrateSalarySlip();
		generatepdf.createPDF(slip);
		
		System.out.println(slip.getEmployeeRegistration().getEmployeeId());
		System.out.println(slip.getSalaryid());
		return slip;
		
	}
	
	//Mail Sending ===============================================================================
	
	public void sendEmail(AdminRegistration newAdminRegistration) throws Exception {   
		   
		   MimeMessage message = emailsend.createMimeMessage();
		           MimeMessageHelper helper = new MimeMessageHelper(message);
		           Map<String, Object> model = new HashMap<>();
		           model.put("user", newAdminRegistration.getAdminFirstName());
		           fremakcon.setClassForTemplateLoading(this.getClass(), "/");
		           Template t = fremakcon.getTemplate("welcome.ftl");
		           String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		           helper.setTo(newAdminRegistration.getAdminEmail());
		           helper.setText(text, true); // set to html
		           helper.setSubject("Hi");
		           emailsend.send(message);
		       }
	
	public void sendEmailEmp(EmployeeRegistration employeeRegistration) throws Exception {   
		   
		   MimeMessage message = emailsend.createMimeMessage();
		           MimeMessageHelper helper = new MimeMessageHelper(message);
		           Map<String, Object> model = new HashMap<>();
		           model.put("user", employeeRegistration.getEmployeeFirstName());
		           fremakcon.setClassForTemplateLoading(this.getClass(), "/");
		           Template t = fremakcon.getTemplate("welcome.ftl");
		           String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		           helper.setTo(employeeRegistration.getEmployeeEmail());
		           helper.setText(text, true); // set to html
		           helper.setSubject("Hi");
		           emailsend.send(message);
		       }


}
