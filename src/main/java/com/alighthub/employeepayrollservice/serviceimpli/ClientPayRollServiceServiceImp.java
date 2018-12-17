package com.alighthub.employeepayrollservice.serviceimpli;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import com.alighthub.employeepayrollservice.dao.ClientPayRollServiceDao;
import com.alighthub.employeepayrollservice.model.Client;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.UserRegistration;
import com.alighthub.employeepayrollservice.service.ClientPayRollserviceService;



@Service
public class ClientPayRollServiceServiceImp implements ClientPayRollserviceService{

	@Autowired
	private ClientPayRollServiceDao clientpayrollserviceDao;
	
	@Override
	public Client clientProfile(Integer client_id) {
		
		Client list=clientpayrollserviceDao.clientProfile(client_id);
		return list;			
	}

	@Override
	public List<UserRegistration> getUsers(Integer cid) {
		
		List<UserRegistration> userregister= clientpayrollserviceDao.getUsers(cid);
		return userregister;
		
	}	
	
}
