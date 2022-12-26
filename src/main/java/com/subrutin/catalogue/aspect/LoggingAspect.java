package com.subrutin.catalogue.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LoggingAspect {

	// dapat lebih detail menentukan join poin method mana hingga argumen seperti
	// apa
	@Pointcut("execution(* com.subrutin.catalogue.web.*.*(..))")
	private void restAPI() {
	}

	// pilihan terbatas
	@Pointcut("within(com.subrutin.catalogue.web.*)")
	private void withinPointCutExample() {
	}

	@Pointcut("args(com.subrutin.catalogue.dto.PublisherCreateRequestDTO)")
	private void argsPointCutExample() {
	}

	@Pointcut("@args(com.subrutin.catalogue.annotation.LogThisArg)")
	private void argsAnnotationPoincutExample() {

	}

	@Pointcut("@annotation(com.subrutin.catalogue.annotation.LogThisMethod)")
	private void annotationPointcutExample() {
	}

	// advise before
	@Before("annotationPointcutExample()")
	public void beforeExecutedLog() {
		log.info("this is log from aspect annotation before method executed");
	}

	// advise before
	@After("annotationPointcutExample()")
	public void afterExecutedLog() {
		log.info("this is log from aspect annotation after method executed");
	}

	// advise before
	@AfterReturning("annotationPointcutExample()")
	public void afterReturnExecutedLog() {
		log.info("this is log from aspect annotation after return method executed");
	}

	// advise before
	@AfterThrowing("annotationPointcutExample()")
	public void afterThrowingExecutedLog() {
		log.info("this is log from aspect annotation after throwing method executed");
	}

	@Around("restAPI()")
	public Object processingTimeLogging(ProceedingJoinPoint joinPoint) throws Throwable {

		StopWatch stopWatch = new StopWatch();
		try {
			log.info("start {}.{} ", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
			stopWatch.start();
			return joinPoint.proceed();
		} finally {
			stopWatch.stop();
			log.info("finish {}.{} execution time = {} ", joinPoint.getTarget().getClass().getName(),
					joinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());

		}

	}

}
