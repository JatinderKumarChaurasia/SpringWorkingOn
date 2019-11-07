package com.jkc.SecurityApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	// In Memory Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		// super.configure(auth);
		/*
		 * @SuppressWarnings("deprecation") UserBuilder userBuilder =
		 * User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication().withUser(userBuilder.username(
		 * "Absolute").password("absolute").roles("EMPLOYEE"))
		 * .withUser(userBuilder.username("Nick").password("nick").roles(
		 * "MANAGER", "EMPLOYEE"))
		 * .withUser(userBuilder.username("Williams").password("williams").roles
		 * ("ADMIN","EMPLOYEE"));
		 */
	}

	// Custom Login Page
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Goto Page According to Their Role
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN").and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll(true).and().logout()
				.permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");

	}

}
