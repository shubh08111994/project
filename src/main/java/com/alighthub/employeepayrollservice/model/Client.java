package com.alighthub.employeepayrollservice.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import org.hibernate.type.BlobType;

@Entity
public class Client {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int client_id;
	private String client_name;
	private int contact;
	private String email;
	@Lob
	private BlobType logo;
	public BlobType getLogo() {
		return logo;
	}
	public void setLogo(BlobType logo) {
		this.logo = logo;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Login login;
	//============================================One to Many===========================================//
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="client_id")
	private List<UserRegistration> user;
	
	public List<UserRegistration> getUser() {
		return user;
	}
	//==================================================================================================//
	public void setUser(List<UserRegistration> user) {
		this.user = user;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
	
	
}
