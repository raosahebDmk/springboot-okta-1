package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

	public SecurityFilterChain securityFitlerChain(HttpSecurity http) throws Exception
	{
		http
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/auth/**").permitAll()
			.anyRequest().authenticated()
		)
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		
		
	return http.build();
	}
	
	
}
