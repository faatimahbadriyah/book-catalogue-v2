package com.subrutin.catalogue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.subrutin.catalogue.service.AppUserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	void registerProvider(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
		auth.userDetailsService(appUserService).passwordEncoder(passwordEncoder);
	}

}
