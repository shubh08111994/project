package com.alighthub.employeepayrollservice.serviceimpli;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alighthub.employeepayrollservice.dao.EmployeePayRollServiceLoginDao;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.service.EmployeePayRollserviceLoginService;

@Service
public class EmployeePayRollServiceLoginServiceImpli implements EmployeePayRollserviceLoginService{

	@Autowired
	private EmployeePayRollServiceLoginDao  employeePayRollServiceDao;
	
	
	
	@Override
	public Login checkLogin(Login login) {
		
		Login list=employeePayRollServiceDao.checkLogin(login);
		return list;	
	}
	
}
