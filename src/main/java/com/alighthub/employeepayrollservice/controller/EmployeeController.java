package com.alighthub.employeepayrollservice.controller;


import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alighthub.employeepayrollservice.model.EmployeeRegistration;
import com.alighthub.employeepayrollservice.model.MonthlySalaryGenrate;
import com.alighthub.employeepayrollservice.model.UserRegistration;
import com.alighthub.employeepayrollservice.service.EmployeePayRollserviceEmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employeeController")
public class EmployeeController {
	@Autowired
	private EmployeePayRollserviceEmployeeService employeePayRollserviceEmployeeService;

	
	
	@PostMapping("/insertuserdata")
	public boolean insertUserRegistrationData(@RequestBody UserRegistration userRegistration) {
	
	
		boolean flag=employeePayRollserviceEmployeeService.insertUserRegistrationData(userRegistration);
		
		if(flag) {
		/*try {
		employeePayRollserviceEmployeeService.sendEmail(userRegistration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			flag=true;
		}
		return flag;
		
		
	}
	@GetMapping(value="/getEmployeeDetails/{employeeId}")
	public EmployeeRegistration getEmployeeDetails(@PathVariable int employeeId) {
		
		return employeePayRollserviceEmployeeService.getEmployeeDetails(employeeId);
	}
	
	@PostMapping("/getSalaryDetails")
	public void getSalaryDetails(@RequestBody Set<String> salaryDetails) {
	
		employeePayRollserviceEmployeeService.genrateSalary(salaryDetails);
		
	}
	
	@PostMapping("/sendDataforGenrateMontlySalary")
	public void getDataforGenrateMontlySalary(@RequestBody MonthlySalaryGenrate monthlySalaryGenrate) {
		employeePayRollserviceEmployeeService.getFixedSalaryDetail(monthlySalaryGenrate);
		
	}
	
	@GetMapping("/getClientCompanyName")
	public Set<String> getClientCompanyNameList() {
		
		return employeePayRollserviceEmployeeService.getClientCompanyNameList();
		
	}
}
