package com.monish.managecustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManagecustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagecustomerApplication.class, args);
	}

}
