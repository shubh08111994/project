package com.alighthub.employeepayrollservice.model;

import java.sql.Date;
import java.util.Set;

import org.hibernate.annotations.Parameter;
import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Entity
public class UserRegistration {

	@GenericGenerator(name = "generator", strategy = "foreign",
			parameters = @Parameter(name = "property", value = "login"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false)
	private int  userrid;

	private String userFirstName;

	private String userLastName;

	private String userMobile;

	private String userEmail;

	private String gender;

	private String designation;

	private String department;

	private double basicSalary;

	private String jobTitle;
	
	private String companyName;


	//@JsonBackReference(value="user")
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private  Login  login;


	private Date dateOfBirth;

	private Date dateOfJoining;

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	public String getUserFirstName() {
		return userFirstName;
	}
	public int getUserrid() {
		return userrid;
	}
	public void setUserrid(int userrid) {
		this.userrid = userrid;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "UserRegistration [userrid=" + userrid + ", userFirstName=" + userFirstName + ", userLastName="
				+ userLastName + ", userMobile=" + userMobile + ", userEmail=" + userEmail + ", gender=" + gender
				+ ", designation=" + designation + ", department=" + department + ", basicSalary=" + basicSalary
				+ ", jobTitle=" + jobTitle + ", login=" + login + ", dateOfBirth=" + dateOfBirth + ", dateOfJoining="
				+ dateOfJoining + ", getDesignation()=" + getDesignation() + ", getDepartment()=" + getDepartment()
				+ ", getBasicSalary()=" + getBasicSalary() + ", getJobTitle()=" + getJobTitle() + ", getGender()="
				+ getGender() + ", getDateOfBirth()=" + getDateOfBirth() + ", getDateOfJoining()=" + getDateOfJoining()
				+ ", getLogin()=" + getLogin() + ", getUserFirstName()=" + getUserFirstName() + ", getUserrid()="
				+ getUserrid() + ", getUserLastName()=" + getUserLastName() + ", getUserMobile()=" + getUserMobile()
				+ ", getUserEmail()=" + getUserEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}
