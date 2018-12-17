package com.alighthub.employeepayrollservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

@Entity
public class AdminRegistration {
	@Id
	@GenericGenerator(name="generator", strategy = "foreign",
	parameters=@Parameter(name="property",value="login"))
	@GeneratedValue(generator="generator")
	@Column(name="Admin_id",unique=true,nullable=false)
	private int adminid;
	
	@JsonBackReference(value="admin")
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Login login;
	
	private String adminFirstName;
	private String adminLastName;
	private String adminAddress;
	private String adminEmail;
	private long adminMobile;
	private Date dateOfJoining;
	private Date dateOfBirth;
	private String adminGender;
	private String department;
	private String designation;
	private double basicSalary;
	private String jobTitle;
		
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public String getAdminAddress() {
		return adminAddress;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public long getAdminMobile() {
		return adminMobile;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getAdminGender() {
		return adminGender;
	}
	public String getDepartment() {
		return department;
	}
	public String getDesignation() {
		return designation;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public void setAdminMobile(long adminMobile) {
		this.adminMobile = adminMobile;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getAdminid() {
		return adminid;
	}
	public Login getLogin() {
		return login;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public void setLogin(Login login) {
		this.login = login;
	}	
}
