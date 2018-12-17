package com.alighthub.employeepayrollservice.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alighthub.employeepayrollservice.model.AdminRegistration;
import com.alighthub.employeepayrollservice.model.Client;
import com.alighthub.employeepayrollservice.model.ClientOnbording;
import com.alighthub.employeepayrollservice.model.EmployeeRegistration;
import com.alighthub.employeepayrollservice.model.Login;
import com.alighthub.employeepayrollservice.model.MonthlySalaryGenrate;
import com.alighthub.employeepayrollservice.model.SalarySlipStructure;
import com.alighthub.employeepayrollservice.model.UserRegistration;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("com")
@PropertySource("classpath:application.properties")
public class MyConfig extends WebMvcConfigurerAdapter {

	@Value("${spring.mail.username}")
	private String mail_id;

	@Value("${spring.mail.password}")
	private String mail_password;

	@Value("${spring.datasource.driver-class-name}")
	private String classname;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hbm2ddl;

	@Value("${spring.jpa.show-sql}")
	private String show_sql;

	@Value("${spring.jpa.dialect}")
	private String dialect;

	@Bean
	public DataSource data() {
		DriverManagerDataSource d = new DriverManagerDataSource();
		d.setDriverClassName(classname);
		d.setUrl(url);
		d.setUsername(username);
		d.setPassword(password);

		return d;
	}

	@Bean
	public LocalSessionFactoryBean getHibernateProperties() {
		LocalSessionFactoryBean ls = new LocalSessionFactoryBean();
		ls.setDataSource(data());
		Properties p = new Properties();
		p.put("hibernate.show_sql", show_sql);
		p.put("hibernate.hbm2ddl.auto", hbm2ddl);
		p.put("hibernate.dialect", dialect);
		ls.setHibernateProperties(p);
		ls.setAnnotatedClasses(ClientOnbording.class, 
				AdminRegistration.class, MonthlySalaryGenrate.class,
				SalarySlipStructure.class, Login.class, UserRegistration.class,
				EmployeeRegistration.class,Client.class);

		return ls;
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl sm = new JavaMailSenderImpl();
		sm.setHost("smtp.gmail.com");
		sm.setPort(587);
		sm.setUsername(mail_id);
		sm.setPassword(mail_password);

		Properties props = sm.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return sm;
	}

	@Bean
	public CommonsMultipartResolver m1() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		return cmr;

	}
}