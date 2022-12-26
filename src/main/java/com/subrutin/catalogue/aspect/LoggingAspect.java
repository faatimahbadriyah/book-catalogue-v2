package com.subrutin.catalogue.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LoggingAspect {
	
	//dapat lebih detail menentukan join poin method mana hingga argumen seperti apa
	@Pointcut("execution(* com.subrutin.catalogue.web.*.*(..))")
	private void restAPI() {}
	
	//pilihan terbatas
	@Pointcut("within(com.subrutin.catalogue.web.*)")
	private void withinPointCutExample() {}
	
	@Pointcut("args(com.subrutin.catalogue.dto.PublisherCreateRequestDTO)")
	private void argsPointCutExample() {}
	
	@Pointcut("@args(com.subrutin.catalogue.annotation.LogThisArg)")
	private void argsAnnotationPoincutExample() {
		
	}
	
	//advise
	@Before("restAPI() && argsAnnotationPoincutExample()")
	public void beforeExecutedLog() {
		
		log.info("this is log from aspect execution with @args");
		
	}

}
