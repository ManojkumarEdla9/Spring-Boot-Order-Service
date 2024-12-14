package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
public class AppConfig {
@Bean
public DataSource dataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("com.Oracle.cj.jdbc.Driver");
	dataSource.setUrl("jdbc:Oracle:@localhost:1521;XE");
	dataSource.setUsername("System");
	dataSource.setPassword("Mj123");
	return dataSource;
	
}
}
