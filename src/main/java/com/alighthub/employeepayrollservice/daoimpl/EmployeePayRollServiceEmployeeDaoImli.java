package com.alighthub.employeepayrollservice.daoimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.alighthub.employeepayrollservice.dao.EmployeePayRollServiceEmployeeDao;
import com.alighthub.employeepayrollservice.model.Client;
import com.alighthub.employeepayrollservice.model.EmployeeRegistration;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.MonthlySalaryGenrate;
import com.alighthub.employeepayrollservice.model.SalarySlipStructure;
import com.alighthub.employeepayrollservice.model.UserRegistration;
@Repository
public class EmployeePayRollServiceEmployeeDaoImli implements EmployeePayRollServiceEmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;

	EmployeeRegistration employeeRegistration=new EmployeeRegistration();

	@Override
	public void insertUserRegistrationData(UserRegistration userRegistration, Login login) {
		Set<UserRegistration> userRegistrationsSet=new HashSet<>();
		
		try (Session session = sessionFactory.openSession()) {

			String HQL="From UserRegistration WHERE Employee_id=?";
			Query<UserRegistration> query=session.createQuery(HQL,UserRegistration.class);
			query.setParameter(0,employeeRegistration.getEmployeeId());
			List<UserRegistration> userRegistrationList=query.list();

			for(UserRegistration user1:userRegistrationList) {
				userRegistrationsSet.add(user1);
			}

		
			userRegistrationsSet.add(userRegistration);
			employeeRegistration.setUserRegistration(userRegistrationsSet);
			employeeRegistration.setLogin(login);
			//session.saveOrUpdate(employeeRegistration);


			session.beginTransaction().commit();

			session.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public EmployeeRegistration getEmployeeDetails(int employeeId) {

		try (Session session = sessionFactory.openSession()) {

			employeeRegistration=session.get(EmployeeRegistration.class, employeeId);
			Login login=session.get(Login.class, employeeId);
			employeeRegistration.setLogin(login);
			session.beginTransaction().commit();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeRegistration;
	}

	@Override
	public SalarySlipStructure genrateSalary(UserRegistration userRegistration,SalarySlipStructure salarySlipStructure) {
		try (Session session = sessionFactory.openSession()) {
			
			employeeRegistration.getUserRegistration().add(userRegistration);
			session.saveOrUpdate(employeeRegistration);
			session.saveOrUpdate(salarySlipStructure);
			session.beginTransaction().commit();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SalarySlipStructure getFixedSalaryDetail(int monthelySalaryId) {
		SalarySlipStructure salarySlipStructure=new SalarySlipStructure();
		try (Session session = sessionFactory.openSession()) {
			String HQL="From SalarySlipStructure WHERE userRegistration_user_id=:id";

			Query<SalarySlipStructure> query=session.createQuery(HQL,SalarySlipStructure.class);
			query.setParameter("id",monthelySalaryId);
			salarySlipStructure=query.getSingleResult();
			System.out.println(salarySlipStructure);


			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salarySlipStructure;

	}

	@Override
	public void createMonthlySalary(MonthlySalaryGenrate monthlySalaryGenrate,int monthelySalaryId,SalarySlipStructure salarySlipStructure) {
		try (Session session = sessionFactory.openSession()) {

			UserRegistration userRegistration=session.get(UserRegistration.class, monthelySalaryId);
			Login login=session.get(Login.class, monthelySalaryId);
			userRegistration.setLogin(login);
			System.out.println(userRegistration);
			System.out.println(monthlySalaryGenrate);

			monthlySalaryGenrate.setUserRegistration(userRegistration);
			monthlySalaryGenrate.setMonthelySalaryId(0);
			session.saveOrUpdate(monthlySalaryGenrate);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkDuplicateEmail(String email) {
		boolean flag = false;
		try(Session session=sessionFactory.openSession()){
			
			String HQL="Select userEmail FROM UserRegistration";
			Query<String> query=session.createQuery(HQL,String.class);
			List<String> mailList=query.list();
			
			for(String mail:mailList) {
				
				if(email.equals(mail)) {
					
					flag=false;
					break;
				}
				else {
					flag = true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
		
	}

	@Override
	public Set<String> getClientCompanyNameList() {
		
		Set<String> client_names=new HashSet<>();
		try(Session session=sessionFactory.openSession()){
			
			String HQL="Select client_name FROM Client";
			Query<String> query=session.createQuery(HQL,String.class);
			List<String> client_nameList=query.list();
			client_names.addAll(client_nameList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return client_names;
	}

	@Override
	public Client getClientData(String companyName) {
		Client client=new Client();
		
		try (Session session = sessionFactory.openSession()) {
			String HQL="From Client WHERE client_name=:companyName";

			Query<Client> query=session.createQuery(HQL,Client.class);
			query.setParameter("companyName",companyName);
			client=query.getSingleResult();
			
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return client;
	}
	
	
	

}
