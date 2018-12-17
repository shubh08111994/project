package com.alighthub.employeepayrollservice.daoimpl;


import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

import com.alighthub.employeepayrollservice.dao.ClientPayRollServiceDao;
import com.alighthub.employeepayrollservice.model.Client;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.UserRegistration;
import com.itextpdf.text.log.SysoLogger;

@Repository
public class ClientPayRollServiceDaoImp implements ClientPayRollServiceDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Client clientProfile(Integer client_id ) {
	
		   Session session=sessionFactory.openSession();
		   CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Client> cQuery=builder.createQuery(Client.class);
			
			Root<Client> root=cQuery.from(Client.class);
		
			cQuery.select(root).where(builder.equal(root.get("client_id"),client_id));
		     Query<Client>query=session.createQuery(cQuery);
				
		       Client list=query.getSingleResult();
				System.out.println(list.getClient_id()+" "+list.getClient_name()+" "+list.getLogo());
				return list;
		
			
		
	}

	
	/*public List<UserRegistration> getUsers(Integer cid)
	{
		System.out.println(cid);
		Session session=sessionFactory.openSession();
		String hql = "from UserRegistration where client_id=:cid";
		System.out.println(hql);
		Query query=session.createQuery(hql);
		    query.setParameter("cid", cid);
		List<UserRegistration> list = (List<UserRegistration>)query.list();
            System.out.println(list);
		return list;
	}*/
	
	public List<UserRegistration> getUsers(Integer cid){
		System.out.println("in dao layer "+cid);
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserRegistration where client_id="+cid);
		List<UserRegistration> list=query.list();
		for(UserRegistration u:list) {
			System.out.println(u.getBasicSalary()+" "+u.getUserFirstName()+" "+u.getUserEmail());
		}
		return list;
	}
	
	
		
	}


