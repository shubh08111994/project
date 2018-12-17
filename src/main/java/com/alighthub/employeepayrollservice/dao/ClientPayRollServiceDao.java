package com.alighthub.employeepayrollservice.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.alighthub.employeepayrollservice.model.Client;
import com.alighthub.employeepayrollservice.model.UserRegistration;



public interface ClientPayRollServiceDao {
	
	public Client clientProfile(Integer client_id);

	public List<UserRegistration> getUsers(Integer cid);
   
}
