package com.alighthub.employeepayrollservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
public class EmployeePayrollServiceApplication {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(EmployeePayrollServiceApplication.class);
		SpringApplication.run(EmployeePayrollServiceApplication.class, args);
		logger.info("This is Info Msg");
		logger.error("This is Error Msg");
		logger.fatal("This is Fatal Msg");
		logger.warn("This is Warnning Msg");
		
		
		
	}
}

