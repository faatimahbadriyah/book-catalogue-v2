package com.subrutin.catalogue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subrutin.catalogue.dto.HelloMessageResponseDTO;
import com.subrutin.catalogue.service.GreetingService;

@RestController
public class HelloResources {
	
	Logger log = LoggerFactory.getLogger(HelloResources.class);
	
	private GreetingService greetingService;
	
	public HelloResources(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	@GetMapping("/hello")
	public ResponseEntity<HelloMessageResponseDTO> helloWorld() {
		//level log
		log.trace("This is log TRACE");
		log.debug("This is log DEBUG");
		log.info("This is log INFO");
		log.warn("This is log WARN");
		log.error("This is log ERROR");
		
		HelloMessageResponseDTO dto = new HelloMessageResponseDTO();
		dto.setMessage(greetingService.sayGreeting());
		return ResponseEntity.accepted().body(dto);
	}

}
