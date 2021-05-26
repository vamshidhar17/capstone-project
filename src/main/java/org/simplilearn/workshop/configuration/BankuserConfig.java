package org.simplilearn.workshop.configuration;

import javax.sql.DataSource;

import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.service.Bankuserservice;
import org.simplilearn.workshop.service.BankuserserviceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("org.simplilearn.workshop")
public class BankuserConfig {
	
	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/icin-bank-db?useSSl=false");
		ds.setUsername("root");
		ds.setPassword("Vamshi@123");

		return ds;
	}

	
	
	@Bean
	public Bankuserservice getBankuser() {
		return new BankuserserviceImpl(getDataSource());
	}

}
