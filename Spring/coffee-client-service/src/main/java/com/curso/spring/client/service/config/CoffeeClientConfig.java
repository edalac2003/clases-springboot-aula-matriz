package com.curso.spring.client.service.config;

import org.springframework.beans.factory.annotation.Autowired;
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

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) 
//	  throws Exception {
//	    auth.inMemoryAuthentication()
//	      .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
//	      .and()
//	      .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");
//	}
	
	@Bean
	public UserDetailsService userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
		
		UserDetailsService userDetailsService = new InMemoryUserDetailsManager();
//		auth.inMemoryAuthentication()
//			.withUser("user").password(passwordEncoder().encode("12345")).roles("CREATE")
//			.and()
//			.withUser("admin").password(passwordEncoder().encode("12345")).roles("CREATE", "QUERY")
//			.and()
//			.withUser("query").password(passwordEncoder().encode("12345")).roles("QUERY");
		UserDetails query = User.withUsername("query")
				.password(passwordEncoder().encode("12345")).roles("QUERY").build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("12345")).roles("ADMIN").build();
		UserDetails root = User.withUsername("root")
				.password(passwordEncoder().encode("12345")).roles("ADMIN", "QUERY").build();
		
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
//		httpSecurity.httpBasic().and().authorizeRequests()
//			.antMatchers(HttpMethod.POST, "/client/**").hasRole("ADMIN");
//		httpSecurity.authorizeRequests().anyRequest().hasAuthority("ROLE_CREATE");
//		httpSecurity.authorizeHttpRequests()
//			.antMatchers(HttpMethod.POST).hasRole("ADMIN")
//			.antMatchers("/client/create").hasRole("ADMIN");
//		httpSecurity.authorizeRequests()
//			.antMatchers(HttpMethod.POST).permitAll()
//			.antMatchers("/client/create").permitAll();
		httpSecurity.authorizeRequests()
		.antMatchers("/client/create")
        .hasRole("ADMIN")               
        .and()
        .authorizeRequests()
        .antMatchers("/client/**")
        .permitAll()
        .anyRequest() 
        .authenticated()
        .and()
        .httpBasic();
		
		return httpSecurity.build();
	}
}
