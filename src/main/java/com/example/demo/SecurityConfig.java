package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends
WebSecurityConfigurerAdapter {

@Override
public void configure(WebSecurity web) throws
Exception {
web.ignoring().antMatchers("/webjars/* *", "/css/* *");
}

@Override
protected void configure(HttpSecurity http)
throws Exception {

http
	.autorizeRequests()
.antMatchers("/webjars/* *").permitAll()
.antMatchers("/css/* *").permitAll()
.antMatchers("/login").permitAll()
.antMatchers("/signup").permitAll()
.anyRequest().authenticated();
http.csrf().disable();
	}
}