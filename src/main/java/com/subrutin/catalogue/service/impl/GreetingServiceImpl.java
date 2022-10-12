package com.subrutin.catalogue.service.impl;


import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.config.ApplicationProperties;
import com.subrutin.catalogue.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	private ApplicationProperties appProperties;

	public GreetingServiceImpl(ApplicationProperties appProperties) {
		super();
		this.appProperties = appProperties;
	}

	@Override
	public String sayGreeting() {
		TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
		return appProperties.getWelcomeText()+", our timezone :"+timezone.getDisplayName()+
				", our currency: "+appProperties.getCurrency();
	}

}
