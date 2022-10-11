package com.subrutin.catalogue.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResources {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World from Spring Book test";
	}

}
