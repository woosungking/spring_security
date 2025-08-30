package com.java.security.session.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityBeanConfig {
	@Bean
	public BCryptPasswordEncoder encode(){
		return new BCryptPasswordEncoder();
	}
}
