package com.alighthub.employeepayrollservice.dao;



import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.SalarySlipStructure;
import com.alighthub.employeepayrollservice.model.AdminRegistration;
import com.alighthub.employeepayrollservice.model.EmployeeRegistration;

public interface EmployeePayRollServiceDao {
	
	public Login checkLogin(Login login);
	public void adminRegisterCheck(AdminRegistration newAdminRegistration);
	public void employeeRegistration(EmployeeRegistration employeeRegistration,SalarySlipStructure salarySlipStructure);
	public SalarySlipStructure employeSalaryStructure(int id);
	
	
}
