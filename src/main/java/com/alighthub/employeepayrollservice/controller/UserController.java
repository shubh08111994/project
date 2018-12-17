package com.alighthub.employeepayrollservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.MonthlySalaryGenrate;
import com.alighthub.employeepayrollservice.model.UserRegistration;
import com.alighthub.employeepayrollservice.service.EmployeePayRollServiceUserService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {

	//==========================================================Autowire of all user==================================//
	@Autowired
	private EmployeePayRollServiceUserService userpayslipservice;

	//===============================================mapping information of all user==================================//	

	//==========User Pay Slip==========//
	@PostMapping(value="/userPayslip")
	public MonthlySalaryGenrate payslipdata(@RequestBody MonthlySalaryGenrate monthlySalaryGenrate)
	{
		//System.out.println("in salaryslip "+ps.getUser().getUserrid());
		MonthlySalaryGenrate payslip =userpayslipservice.paySlipPost(monthlySalaryGenrate);

		return payslip;
	}

	//==========User Personal Details==========//
	@GetMapping(value="/userPersonalDetails/{userrid}")
	public UserRegistration getUserPersonalDetailsById(@PathVariable ("userrid") Integer userrid)
	{
		UserRegistration upd1 = userpayslipservice.userPersonalDatails(userrid);
		System.out.println(upd1.getUserFirstName()+" "+upd1.getLogin().getLogin_roll());

		return upd1;
	}
	//==================================================================================================================//

	@GetMapping(value="/confirmPassword/{oldPassword}")
	public boolean confirmPassword(@PathVariable("oldPassword") String password) {
		System.out.println("contr");
		
	System.out.println("Login pass is :-"+password);
			
		
		
		
		return userpayslipservice.getpassword1(password);
		
	}
//=========================================================================================================================//	
	
	
	@PostMapping(value="/changepass")
	public int changepass(@RequestBody Login login)
	{
		System.out.println(""+login.getLogin_pass());
	int list= userpayslipservice.changepassword(login);
	System.out.println("new  Password :-"+login.getLogin_pass());
	return list;	
	}

//	
//	@PutMapping(value="/chagepass/{lid}")
//	public String changepassword(@RequestBody Login login )
//	{
//		System.out.println("login id:-"+login.getLid());
//		
//		String login1=userpayslipservice.changepassword(login);
//
//		return login1;
//	}
//
//
//	@GetMapping(value="/chagepass1/{lid}")
//	public Login chagepassword1(Login login)
//	{
//		Login login1=userpayslipservice.changepassword1(login);
//		
//		return login1;
//	}


}
