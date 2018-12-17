package com.alighthub.employeepayrollservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MonthlySalaryGenrate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int monthelySalaryId;

	
	private String month;
	private int year;
	private int numberOfDays;
	
	
	private double netSalary;
	private double annualpackage;
	//=================================Adding====================================================//


	private double gradePay;
	private double DA;
	private double HRA;
	private double TA;
	private double grossSalary;

	//=================================Diduction====================================================//
	private double incomeTax;
	private double PF;
	private double PT;
	private double LIC;
	private double RD;
	private double insurance;
	private double leavDeducton;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private UserRegistration userRegistration;
	
	public int getMonthelySalaryId() {
		return monthelySalaryId;
	}
	public void setMonthelySalaryId(int monthelySalaryId) {
		this.monthelySalaryId = monthelySalaryId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public double getAnnualpackage() {
		return annualpackage;
	}
	public void setAnnualpackage(double annualpackage) {
		this.annualpackage = annualpackage;
	}
	public double getGradePay() {
		return gradePay;
	}
	public void setGradePay(double gradePay) {
		this.gradePay = gradePay;
	}
	public double getDA() {
		return DA;
	}
	public void setDA(double dA) {
		DA = dA;
	}
	public double getHRA() {
		return HRA;
	}
	public void setHRA(double hRA) {
		HRA = hRA;
	}
	public double getTA() {
		return TA;
	}
	public void setTA(double tA) {
		TA = tA;
	}
	public double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	public double getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}
	public double getPF() {
		return PF;
	}
	public void setPF(double pF) {
		PF = pF;
	}
	public double getPT() {
		return PT;
	}
	public void setPT(double pT) {
		PT = pT;
	}
	public double getLIC() {
		return LIC;
	}
	public void setLIC(double lIC) {
		LIC = lIC;
	}
	public double getRD() {
		return RD;
	}
	public void setRD(double rD) {
		RD = rD;
	}
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	
	
	
	
	public double getLeavDeducton() {
		return leavDeducton;
	}
	public void setLeavDeducton(double leavDeducton) {
		this.leavDeducton = leavDeducton;
	}
	
	
	public UserRegistration getUserRegistration() {
		return userRegistration;
	}
	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}
	@Override
	public String toString() {
		return "MonthlySalaryGenrate [monthelySalaryId=" + monthelySalaryId + ", month=" + month + ", year=" + year
				+ ", numberOfDays=" + numberOfDays + ", netSalary=" + netSalary + ", annualpackage=" + annualpackage
				+ ", gradePay=" + gradePay + ", DA=" + DA + ", HRA=" + HRA + ", TA=" + TA + ", grossSalary="
				+ grossSalary + ", incomeTax=" + incomeTax + ", PF=" + PF + ", PT=" + PT + ", LIC=" + LIC + ", RD=" + RD
				+ ", insurance=" + insurance + ", getMonthelySalaryId()=" + getMonthelySalaryId() + ", getMonth()="
				+ getMonth() + ", getYear()=" + getYear() + ", getNumberOfDays()=" + getNumberOfDays()
				+ ", getNetSalary()=" + getNetSalary() + ", getAnnualpackage()=" + getAnnualpackage()
				+ ", getGradePay()=" + getGradePay() + ", getDA()=" + getDA() + ", getHRA()=" + getHRA() + ", getTA()="
				+ getTA() + ", getGrossSalary()=" + getGrossSalary() + ", getIncomeTax()=" + getIncomeTax()
				+ ", getPF()=" + getPF() + ", getPT()=" + getPT() + ", getLIC()=" + getLIC() + ", getRD()=" + getRD()
				+ ", getInsurance()=" + getInsurance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
}
