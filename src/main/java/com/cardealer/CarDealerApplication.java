package com.cardealer;

import app.builder.RepositoryServiceBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealerApplication {

	public static void main(String[] args) {
		RepositoryServiceBuilder.build();
		SpringApplication.run(CarDealerApplication.class, args);
	}
}
