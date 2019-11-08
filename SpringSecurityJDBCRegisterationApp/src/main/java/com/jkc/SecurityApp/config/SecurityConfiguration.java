package com.jkc.SecurityApp.config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jkc.SecurityApp.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private Logger logger = Logger.getLogger(SecurityConfiguration.class.getName());

/*	@Autowired
	private DataSource securityDataSource;*/
	
	@Autowired
	private UserService userService;
	// In Memory Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.jdbcAuthentication().dataSource(securityDataSource);
		auth.authenticationProvider(authenticationProvider());
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

		logger.info("\t Configuring Http Security ---_---_----_---_---_---_");
		// Goto Page According to Their Role
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN").and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll(true).and().logout()
				.permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");

	}
	
	// Bcrypt Initializer
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		logger.info("\t Creating instance of BCryptPasswordEncoder ---_---_----_---_---_---_");
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		logger.info("\t Authentication Provider ---_---_----_---_---_---_");
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

}
