package com.alighthub.employeepayrollservice.daoimpl;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.alighthub.employeepayrollservice.dao.EmployeePayRollServiceDao;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.SalarySlipStructure;
import com.alighthub.employeepayrollservice.model.AdminRegistration;
import com.alighthub.employeepayrollservice.model.EmployeeRegistration;

@Repository
public class EmployeePayRollServiceDaoImli implements EmployeePayRollServiceDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Login checkLogin(Login login) {
		Session session=sessionFactory.openSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Login> cqCriteriaQuery=builder.createQuery(Login.class);
		Root<Login> root=cqCriteriaQuery.from(Login.class);
		
		cqCriteriaQuery.select(root);
		cqCriteriaQuery.where( builder.equal( root.get("login_id"),login.getLogin_id()),builder.equal(root.get("login_pass"),login.getLogin_pass()));
			Query<Login>query=session.createQuery(cqCriteriaQuery);
			Login list=query.getSingleResult();
			return list;
	}

	@Override
	public void adminRegisterCheck(AdminRegistration newAdminRegistration) {
		Session session=sessionFactory.openSession();
		session.save(newAdminRegistration);
		session.beginTransaction().commit();
	}

	@Override
	public void employeeRegistration(EmployeeRegistration employeeRegistration,SalarySlipStructure salarySlipStructure) {
		Session session=sessionFactory.openSession();
		session.save(salarySlipStructure);
		session.save(employeeRegistration);
		session.beginTransaction().commit();
	}

	@Override
	public SalarySlipStructure employeSalaryStructure(int id) {
		
		System.out.println("************************************************************************Dao");
		Session session=sessionFactory.openSession();
		
		Query<SalarySlipStructure> query = session.createQuery("from SalarySlipStructure where employeeRegistration_Employee_id=?");
		query.setParameter(0, id);
		SalarySlipStructure list = query.getSingleResult();
		
		System.out.println("hi");
		return list;
	}
	
	
}
