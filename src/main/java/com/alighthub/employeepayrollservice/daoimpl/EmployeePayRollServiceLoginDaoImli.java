package com.alighthub.employeepayrollservice.daoimpl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.alighthub.employeepayrollservice.dao.EmployeePayRollServiceLoginDao;
import com.alighthub.employeepayrollservice.model.Login;

@Repository
public class EmployeePayRollServiceLoginDaoImli implements EmployeePayRollServiceLoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Login checkLogin(Login login) {

		Login list = new Login();
		try (Session session = sessionFactory.openSession()) {

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Login> cqCriteriaQuery = builder.createQuery(Login.class);
			Root<Login> root = cqCriteriaQuery.from(Login.class);

			cqCriteriaQuery.select(root);
			cqCriteriaQuery.where(builder.equal(root.get("login_id"), login.getLogin_id()),
					builder.equal(root.get("login_pass"), login.getLogin_pass()));
			
			Query<Login> query = session.createQuery(cqCriteriaQuery);
			list = query.getSingleResult();
			
		
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
