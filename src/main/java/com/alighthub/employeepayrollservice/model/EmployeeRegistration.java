package com.alighthub.employeepayrollservice.model;

import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EmployeeRegistration {

	@Id
	@GenericGenerator(name="generator", strategy = "foreign",
	parameters=@Parameter(name="property",value="login"))
	@GeneratedValue(generator="generator")
	@Column(name="Employee_id",unique=true,nullable=false)
	private int employeeId;
	

	private String employeeFirstName;
	private String employeeLastName;
	private String employeeAddress;
	private String employeeEmail;
	private long employeeMobile;
	private Date dateOfJoining;
	private Date dateOfBirth;
	private String employeeGender;
	private String department;
	private String designation;
	private double basicSalary;
	private String jobTitle;
	private double employeePackage;

	@JsonBackReference
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Login login;

	@JsonBackReference(value="employee")
	@OneToMany(fetch=FetchType.LAZY, targetEntity=UserRegistration.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "Employee_id", referencedColumnName="Employee_id")
	private  Set<UserRegistration>  userRegistration;
	
	
	
	public double getEmployeePackage() {
		return employeePackage;
	}

	public void setEmployeePackage(double employeePackage) {
		this.employeePackage = employeePackage;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public Set<UserRegistration> getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(Set<UserRegistration> userRegistration) {
		this.userRegistration = userRegistration;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public long getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(long employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "EmployeeRegistration [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName
				+ ", employeeLastName=" + employeeLastName + ", employeeAddress=" + employeeAddress + ", employeeEmail="
				+ employeeEmail + ", employeeMobile=" + employeeMobile + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfBirth=" + dateOfBirth + ", employeeGender=" + employeeGender + ", department=" + department
				+ ", designation=" + designation + ", basicSalary=" + basicSalary + ", jobTitle=" + jobTitle
				+ ", login=" + login + ", userRegistration=" + userRegistration + ", getEmployeeId()=" + getEmployeeId()
				+ ", getUserRegistration()=" + getUserRegistration() + ", getEmployeeFirstName()="
				+ getEmployeeFirstName() + ", getEmployeeLastName()=" + getEmployeeLastName()
				+ ", getEmployeeAddress()=" + getEmployeeAddress() + ", getEmployeeEmail()=" + getEmployeeEmail()
				+ ", getEmployeeMobile()=" + getEmployeeMobile() + ", getDateOfJoining()=" + getDateOfJoining()
				+ ", getDateOfBirth()=" + getDateOfBirth() + ", getEmployeeGender()=" + getEmployeeGender()
				+ ", getDepartment()=" + getDepartment() + ", getDesignation()=" + getDesignation()
				+ ", getBasicSalary()=" + getBasicSalary() + ", getJobTitle()=" + getJobTitle() + ", getLogin()="
				+ getLogin() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
		
	
}
