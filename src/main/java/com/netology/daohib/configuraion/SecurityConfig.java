package com.netology.daohib.configuraion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
						.withUser("sergey").password("Pass123").authorities("READ")
						.and()
						.withUser("alex").password("Pass321").authorities("WRITE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().and()
						.authorizeRequests().antMatchers("/persons/by-name-surname").permitAll()
						.and()
						.authorizeRequests().antMatchers("/persons/by-age").hasAuthority("READ")
						.and()
						.authorizeRequests().antMatchers("/persons/by-city").hasAuthority("WRITE")
						.and()
						.authorizeRequests().anyRequest().authenticated();
	}

}