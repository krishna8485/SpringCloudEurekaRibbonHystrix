package com.krishna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddressRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressRestApplication.class, args);
	}
}
