package com.curso.spring.client.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CoffeeClientConfig {
	
	@Bean
	public UserDetailsService userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
		
		UserDetailsService userDetailsService = new InMemoryUserDetailsManager();
		UserDetails query = User.withUsername("query")
				.password(passwordEncoder().encode("12345")).authorities("ROLE_QUERY").build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("12345")).authorities("ROLE_CREATE").build();
		UserDetails root = User.withUsername("root")
				.password(passwordEncoder().encode("12345")).authorities("ROLE_CREATE", "ROLE_QUERY").build();
		
		((InMemoryUserDetailsManager)userDetailsService).createUser(query);
		((InMemoryUserDetailsManager)userDetailsService).createUser(admin);
		((InMemoryUserDetailsManager)userDetailsService).createUser(root);
		
		return userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic();
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests()
			.antMatchers("/client/create").hasRole("CREATE")
			.antMatchers("/client/find*/**").hasRole("QUERY");		
		
		return httpSecurity.build();
	}
}
