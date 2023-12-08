package com.Controller;

import jakarta.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.Clases.BD.HibernateManager;

//@Configuration
public class JpaConfig {
	/*@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSourceBuilder.url("jdbc:sqlserver://localhost:1433;databaseName=basediseno");
		dataSourceBuilder.username("admindise");
		dataSourceBuilder.password("admin");
		return (DataSource) dataSourceBuilder.build();
	}*/



}
