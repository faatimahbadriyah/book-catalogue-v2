package com.subrutin.catalogue.service.impl;


import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.subrutin.catalogue.config.ApplicationProperties;
import com.subrutin.catalogue.config.CloudProperties;
import com.subrutin.catalogue.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);
	
	private ApplicationProperties appProperties;
	
	private CloudProperties cloudProperties;

	public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
		super();
		this.appProperties = appProperties;
		this.cloudProperties = cloudProperties;
	}

	@Override
	public String sayGreeting() {
		//level log
		log.trace("This is log TRACE greeting service");
		log.debug("This is log DEBUG greeting service");
		log.info("This is log INFO greeting service");
		log.warn("This is log WARN greeting service");
		log.error("This is log ERROR greeting service");
		System.out.println(cloudProperties.getApiKey());
		TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
		return appProperties.getWelcomeText()+", our timezone :"+timezone.getDisplayName()+
				", our currency: "+appProperties.getCurrency();
	}

}
