package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CrudOperationSpringboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationSpringboot2Application.class, args);
	}

}
