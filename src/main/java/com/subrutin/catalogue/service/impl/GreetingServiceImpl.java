package com.subrutin.catalogue.service.impl;


import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.config.ApplicationProperties;
import com.subrutin.catalogue.config.CloudProperties;
import com.subrutin.catalogue.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	private ApplicationProperties appProperties;
	
	private CloudProperties cloudProperties;

	public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
		super();
		this.appProperties = appProperties;
		this.cloudProperties = cloudProperties;
	}

	@Override
	public String sayGreeting() {
		System.out.println(cloudProperties.getApiKey());
		TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
		return appProperties.getWelcomeText()+", our timezone :"+timezone.getDisplayName()+
				", our currency: "+appProperties.getCurrency();
	}

}
