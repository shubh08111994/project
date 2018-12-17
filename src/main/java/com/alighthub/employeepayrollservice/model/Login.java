package com.alighthub.employeepayrollservice.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id", unique = true, nullable = false)
	private int login_id ;
	
	private int login_roll;
	
	private String login_pass;
	
	@JsonBackReference(value="user")
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "login", cascade = CascadeType.ALL)
	private UserRegistration userRegistration;
	
	@JsonBackReference(value="admin")
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "login", cascade = CascadeType.ALL)
	private AdminRegistration adminRegistration;
	
	@JsonBackReference(value="employee")
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "login", cascade = CascadeType.ALL)
	private EmployeeRegistration employeeRegistration ;
	
	
	public AdminRegistration getAdminRegistration() {
		return adminRegistration;
	}
	public void setAdminRegistration(AdminRegistration adminRegistration) {
		this.adminRegistration = adminRegistration;
	}
	
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public int getLogin_roll() {
		return login_roll;
	}
	public void setLogin_roll(int login_roll) {
		this.login_roll = login_roll;
	}
	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}
	public UserRegistration getUserRegistration() {
		return userRegistration;
	}
	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}
	public EmployeeRegistration getEmployeeRegistration() {
		return employeeRegistration;
	}
	public void setEmployeeRegistration(EmployeeRegistration employeeRegistration) {
		this.employeeRegistration = employeeRegistration;
	}

	
}
