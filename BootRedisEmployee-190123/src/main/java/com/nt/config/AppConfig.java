package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.nt.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public RedisConnectionFactory cf() {
		return new LettuceConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Employee> rt(){
		RedisTemplate<String, Employee> template = new RedisTemplate<>();
		template.setConnectionFactory(cf());
		return template;
	}
}
