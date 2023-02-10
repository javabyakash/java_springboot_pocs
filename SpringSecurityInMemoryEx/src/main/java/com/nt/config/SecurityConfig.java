package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// 1. Authentication
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("akash").password("akash@1").roles("USER")
				.build();
		UserDetails user2 = User.withDefaultPasswordEncoder().username("james").password("james@1").roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
	// 2. Authorization
	@Bean
	public SecurityFilterChain configurePaths(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(request -> request.antMatchers("/","/home").permitAll().anyRequest().authenticated())
		.formLogin(form -> form.loginPage("/login").permitAll())
		.logout(logout -> logout.permitAll());
		return http.build();
	}
	
	
}
