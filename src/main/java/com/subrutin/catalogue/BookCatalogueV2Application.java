package com.subrutin.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BookCatalogueV2Application {

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogueV2Application.class, args);
	}

}
