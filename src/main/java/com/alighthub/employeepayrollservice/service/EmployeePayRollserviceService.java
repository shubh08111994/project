package com.alighthub.employeepayrollservice.service;



import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.SalarySlipStructure;
import com.alighthub.employeepayrollservice.model.AdminRegistration;
import com.alighthub.employeepayrollservice.model.EmployeeRegistration;

public interface EmployeePayRollserviceService {

	public Login checkLogin(Login login);
	public void RegisterCheck(AdminRegistration newAdminRegistration);
	public void employeeRegistration(EmployeeRegistration employeeRegistration);
	public SalarySlipStructure employeSalaryStructure(int id);
	public void sendEmail(AdminRegistration newAdminRegistration)throws Exception;
	public void sendEmailEmp(EmployeeRegistration employeeRegistration)throws Exception;
	
}
