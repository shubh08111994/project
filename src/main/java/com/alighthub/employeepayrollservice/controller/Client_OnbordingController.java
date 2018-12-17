package com.alighthub.employeepayrollservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.employeepayrollservice.model.ClientOnbording;

@CrossOrigin
@RestController
@RequestMapping("/clientonbording")
public class Client_OnbordingController {

	@RequestMapping("/getClintOnbordinData")
	public void getClintOnbordinData(@RequestBody ClientOnbording clientOnbording) {
		
		System.out.println(clientOnbording);
	}
	
}
