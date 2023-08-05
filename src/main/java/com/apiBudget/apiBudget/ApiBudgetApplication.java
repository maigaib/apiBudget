package com.apiBudget.apiBudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApiBudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBudgetApplication.class, args);
		System.out.println("Application lancée avec succès!!!");
	}

}
