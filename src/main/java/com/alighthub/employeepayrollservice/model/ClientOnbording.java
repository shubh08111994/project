package com.alighthub.employeepayrollservice.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientOnbording {

	@Id
	private int companytId;
	private String companyCode;
	private String companyUrl;
	private Date expireyDate;
	private String companyAddress;
	
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public int getCompanytId() {
		return companytId;
	}
	public void setCompanytId(int companytId) {
		this.companytId = companytId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	public String getCompanyUrl() {
		return companyUrl;
	}
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	public Date getExpireyDate() {
		return expireyDate;
	}
	public void setExpireyDate(Date expireyDate) {
		this.expireyDate = expireyDate;
	}
	@Override
	public String toString() {
		return "ClientOnbording [companytId=" + companytId + ", companyCode=" + companyCode + ", companyUrl="
				+ companyUrl + ", expireyDate=" + expireyDate + ", companyAddress=" + companyAddress
				+ ", getCompanyAddress()=" + getCompanyAddress() + ", getCompanytId()=" + getCompanytId()
				+ ", getCompanyCode()=" + getCompanyCode() + ", getCompanyUrl()=" + getCompanyUrl()
				+ ", getExpireyDate()=" + getExpireyDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
