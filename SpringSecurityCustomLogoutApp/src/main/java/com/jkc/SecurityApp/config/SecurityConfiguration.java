package com.jkc.SecurityApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// In Memory Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// super.configure(auth);
		@SuppressWarnings("deprecation")
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(userBuilder.username("Absolute").password("absolute").roles("EMPLOYEE"))
				.withUser(userBuilder.username("Nick").password("nick").roles("MANAGER"))
				.withUser(userBuilder.username("Williams").password("williams").roles("ADMIN"));
	}

	// Custom Login Page
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super.configure(http);
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll(true).and().logout().permitAll();
	}

}
