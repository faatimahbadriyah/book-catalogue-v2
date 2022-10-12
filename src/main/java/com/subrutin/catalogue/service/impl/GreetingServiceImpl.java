package com.subrutin.catalogue.service.impl;


import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.subrutin.catalogue.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	@Value("${welcome.text}")
	private String welcomeText;
	
	@Value("${timezone}")
	private String timeZone;

	@Value("${currency}")
	private String currency;

	@Override
	public String sayGreeting() {
		TimeZone timezone = TimeZone.getTimeZone(timeZone);
		return welcomeText+", our timezone :"+timezone.getDisplayName()+
				", our currency: "+currency;
	}

}
