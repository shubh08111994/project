package com.alighthub.employeepayrollservice.daoimpl;



import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alighthub.employeepayrollservice.dao.EmployeePayRollServiceUserDao;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.MonthlySalaryGenrate;

import com.alighthub.employeepayrollservice.model.UserRegistration;


@Repository
public class EmployeePayRollServiceUserDaoImpli implements EmployeePayRollServiceUserDao {

	//==========================================================Autowire of all user==================================//
	@Autowired
	private SessionFactory sessionFactory;

	//===========================================================menu of payslip======================================//
	@Override
	public MonthlySalaryGenrate paySlipPost(MonthlySalaryGenrate monthlySalaryGenrate) {
		System.out.println("Dao Data "+monthlySalaryGenrate.getUserRegistration().getUserrid());
		Session session=sessionFactory.openSession();

		Query<MonthlySalaryGenrate> query=session.createQuery("from MonthlySalaryGenrate where month=? and year=? and userRegistration_user_id=?");
		query.setParameter(0, monthlySalaryGenrate.getMonth());
		query.setParameter(1, monthlySalaryGenrate.getYear());
		query.setParameter(2,monthlySalaryGenrate.getUserRegistration().getUserrid());

		MonthlySalaryGenrate payslip=new MonthlySalaryGenrate();
		List<MonthlySalaryGenrate> l=query.getResultList();
		for(MonthlySalaryGenrate s:l) {
			payslip=s;
		}
		System.out.println("salary slip info= "+payslip.getNetSalary()+" "+payslip.getMonth());

		/*CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<SalarySlipStructure> cqCriteriaQuery=builder.createQuery(SalarySlipStructure.class);
		Root<SalarySlipStructure> root=cqCriteriaQuery.from(SalarySlipStructure.class);
		Root<UserRegistration> root1=cqCriteriaQuery.from(UserRegistration.class);

		System.out.println("Dao layer ");

		cqCriteriaQuery.multiselect(root,root1);
		cqCriteriaQuery.where( builder.equal( root.get("month"),ps.getMonth()),builder.equal(root.get("year"),ps.getYear())
				,builder.equal(root.get("user"),ps.getUser()),builder.equal(root1.get("userrid"),ps.getUser().getUserrid()));
		System.out.println("Dao layer 11111111");

		// cqCriteriaQuery.where(builder.equal(root.get("salaryid"),ps.getSalaryid()));
		Query<SalarySlipStructure>query=session.createQuery(cqCriteriaQuery);
		SalarySlipStructure payslip=query.getSingleResult();
	System.out.println("Dao layer 222222");*/
		return payslip;
	}

	//===============================================================================================================//
	//=======================================menu of user personal details===========================================//
	@Override
	public UserRegistration userPersonalDatails(Integer userrid) {
		Session session=sessionFactory.openSession();

		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<UserRegistration> cquery=builder.createQuery(UserRegistration.class);

		Root<UserRegistration> root=cquery.from(UserRegistration.class);
		cquery.select(root).where(builder.equal(root.get("userrid"),userrid));  
		Query<UserRegistration> query=session.createQuery(cquery);
		UserRegistration upd1= query.getSingleResult();
		System.out.println(upd1.getUserrid()+""+upd1.getUserEmail());

		return upd1;
	}
	//===============================================================================================================//
	//=======================================change login password===================================================//

	@Override
	public int changepassword(Login login) {
	
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("In dao"+login.getLogin_pass());
		Query query=session.createQuery("UPDATE Login set login_pass =:pass where login_id =:lid");
		System.out.println("Upadte Query:="+query);
		query.setParameter("pass", login.getLogin_pass());
		query.setParameter("lid", login.getLogin_id());
		int login1	= query.executeUpdate();
		return login1;
	}
	//==============================================================================================================//
	//========================================get login password====================================================//
	@Override
	public boolean getpassword1(String password) {
		
		
		Session session=sessionFactory.openSession();
		CriteriaBuilder builder=session.getCriteriaBuilder();
		CriteriaQuery<Login> cqCriteriaQuery=builder.createQuery(Login.class);
		Root<Login> root=cqCriteriaQuery.from(Login.class);
		cqCriteriaQuery.select(root);
		cqCriteriaQuery.where( builder.equal( root.get("login_pass"),password));
		//System.out.println("query check:="+cqCriteriaQuery);
		
		Query<Login>query=session.createQuery(cqCriteriaQuery);
		//@SuppressWarnings("unchecked")
		
		
		
	return query.getResultList().size() != 0;
	
	}	
	
	
	
	//================================================================================================================//
}
