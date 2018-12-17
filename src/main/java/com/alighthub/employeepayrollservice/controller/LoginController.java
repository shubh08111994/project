package com.alighthub.employeepayrollservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.service.EmployeePayRollserviceLoginService;

@CrossOrigin
@RestController
@RequestMapping("/loginController")
public class LoginController {
	
	
	@Autowired
	private EmployeePayRollserviceLoginService employeePayRollserviceService;
	
	@PostMapping(value="/")
	public int LoginCheck(@RequestBody Login login) {
	
		
		Login sendLogin=employeePayRollserviceService.checkLogin(login);
		
		return sendLogin.getLogin_roll();
		
	}		
}
