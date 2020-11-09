package com.winify.shop.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@TODO authorize per request and role
		http.authorizeRequests()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .permitAll()
		    .and()
		    .logout()
		    .permitAll();
	}
}
