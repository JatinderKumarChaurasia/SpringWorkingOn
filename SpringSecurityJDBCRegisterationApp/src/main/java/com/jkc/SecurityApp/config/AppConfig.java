package com.jkc.SecurityApp.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jkc.SecurityApp")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

	private Logger logger = Logger.getLogger(AppConfig.class.getName());

	@Autowired
	private Environment environment;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		logger.info("Fetching JSP PAGE FROM WEB-INF/view");
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		try {
			pooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));

		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		logger.info("Java Database Connectivity -- JDBC-URL:" + environment.getProperty("jdbc.url"));
		logger.info("Java Database Connectivity -- JDBC-USERNAME:" + environment.getProperty("jdbc.username"));
		logger.info("Java Database Connectivity -- JDBC-PASSWORD:" + environment.getProperty("jdbc.password"));
		pooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		pooledDataSource.setUser(environment.getProperty("jdbc.username"));
		pooledDataSource.setPassword(environment.getProperty("jdbc.password"));
		pooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		pooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		pooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		pooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		return pooledDataSource;
	}

	private int getIntProperty(String propertyName) {
		String property = environment.getProperty(propertyName);
		int propertyValue = Integer.parseInt(property);
		return propertyValue;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		logger.info("Showing SQL ------------------->"+environment.getProperty("hibernate.show_sql"));
		logger.info("Hibernate Dialect ------------->"+environment.getProperty("hibernate.dialect"));
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		logger.info("Session Factory Initialized -------------------");
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(securityDataSource());
		localSessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return localSessionFactoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

}
