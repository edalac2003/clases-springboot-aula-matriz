package com.curso.spring.stock.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CoffeeStockConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetailsService userDetailsService = new InMemoryUserDetailsManager();
		UserDetails userDetails = User.withUsername("prueba")
				.password(passwordEncoder().encode("12345678"))
				.authorities("ROLE_USER")
				.build();
		
		((InMemoryUserDetailsManager)userDetailsService).createUser(userDetails);
		
		return userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic();
//		httpSecurity.authorizeRequests().anyRequest().hasAuthority("ROLE_USER");
		httpSecurity.authorizeRequests()
			.antMatchers("/inventory/**")
			.hasAuthority("ROLE_USER")
			.antMatchers("/**")
			.hasAnyAuthority("ROLE_USER");
		
		return httpSecurity.build();
	}
}
