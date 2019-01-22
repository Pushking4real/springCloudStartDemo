package com.abchina.microservice.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BaseMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseMicroserviceApplication.class, args);
	}
}
