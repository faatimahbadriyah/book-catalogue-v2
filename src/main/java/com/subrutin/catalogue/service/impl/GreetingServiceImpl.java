package com.subrutin.catalogue.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.subrutin.catalogue.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	@Value("${welcome.text}")
	private String welcomeText;

	@Override
	public String sayGreeting() {
		return welcomeText;
	}

}
