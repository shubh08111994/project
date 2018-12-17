package com.alighthub.employeepayrollservice.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.employeepayrollservice.model.Client;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.UserRegistration;
import com.alighthub.employeepayrollservice.service.ClientPayRollserviceService;



@CrossOrigin
@RestController
@RequestMapping("/cwelcome")
public class ClientController {
	
	@Autowired
private ClientPayRollserviceService clientpayrollservice;
	
	
	@GetMapping("/{client_id}")
	public Client checkProfile(@PathVariable ("client_id") Integer client_id) {
		System.out.println("hello");
		System.out.println(client_id);
		Client list=clientpayrollservice.clientProfile(client_id);
		return list;
	}

	@GetMapping("/try1")
	public String try1()
	{
		return "Client Project Run";
	}
	
	
	
	@GetMapping("/getUsers/{client_id}")
	public List<UserRegistration> getAllData(@PathVariable("client_id")Integer cid)
	{
		System.out.println("client id:="+cid);
		
		
		
	List<UserRegistration>	UserRegister= clientpayrollservice.getUsers(cid);
	return UserRegister;
	}
}
