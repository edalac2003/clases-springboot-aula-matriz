package com.curso.spring.sales.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class OpenFeignConfigCustomer {
	
	@Value("${client.service.usernameCreate}")
	private String userNameClientCreate;
	
	@Value("${client.service.passwordCreate}")
	private String passwordClientCreate;

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(userNameClientCreate, passwordClientCreate);
	}
}
