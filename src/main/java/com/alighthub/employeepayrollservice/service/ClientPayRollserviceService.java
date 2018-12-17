package com.alighthub.employeepayrollservice.service;

import java.util.List;
import com.alighthub.employeepayrollservice.model.Client;
import com.alighthub.employeepayrollservice.model.UserRegistration;

public interface ClientPayRollserviceService {
	public Client clientProfile(Integer client_id);
	public List<UserRegistration> getUsers(Integer cid);
}
