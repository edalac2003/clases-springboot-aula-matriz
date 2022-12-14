package com.curso.spring.sales.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class OpenFeignConfig {
	
	@Value("${stock.service.username}")
	private String userName;
	
	@Value("${stock.service.password}")
	private String password;
	
	@Value("${client.service.usernameCreate}")
	private String userNameClientCreate;
	
	@Value("${client.service.passwordCreate}")
	private String passwordClientCreate;

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptorStock() {
		return new BasicAuthRequestInterceptor(userName, password);
	}
	
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptorCustomer() {
		return new BasicAuthRequestInterceptor(userNameClientCreate, passwordClientCreate);
	}
}
