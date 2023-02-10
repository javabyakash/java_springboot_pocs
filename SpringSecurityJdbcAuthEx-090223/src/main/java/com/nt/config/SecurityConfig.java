package com.nt.config;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//1. Authentication
	@Bean
	public UserDetailsService userDetails(DataSource datasource) {
		UserDetails user1 = User.withUsername("SAM").password("$2a$10$FAAL3HH3WvFxGua4plKQVeZWzHROlO3a39DfTNpEmESXnSlHaFSDi").authorities("ADMIN").build();
		UserDetails user2 = User.withUsername("AKASH").password("$2a$10$fdsZLnBbfmGh7c4qjfliGuaDqdQKtySkBfQfGDmUYAvsnW/OE83oK").authorities("CUSTOMER").build();
		
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(datasource);
		users.createUser(user1);
		users.createUser(user2);
		
		return users;
	}
	
	//2. Authorization
	@Bean
	public SecurityFilterChain configureAuth(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> request.antMatchers("/home","/").permitAll()
				.antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/customer").hasAuthority("CUSTOMER").anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").permitAll().defaultSuccessUrl("/hello",true))
				.logout(logout -> logout.permitAll());
		return http.build();
	}
}
