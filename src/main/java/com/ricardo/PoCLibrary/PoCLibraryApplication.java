package com.ricardo.PoCLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Library Application", version = "1.0",description = "RESTful API POC built with Spring Boot, based on DDD and Hexagonal Architecture Architecture"))
@SpringBootApplication
public class PoCLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoCLibraryApplication.class, args);
	}

}
