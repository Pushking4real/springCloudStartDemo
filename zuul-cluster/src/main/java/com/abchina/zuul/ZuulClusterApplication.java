package com.abchina.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.abchina.zuul.prefilter.AccessFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulClusterApplication.class, args);
	}
	@Bean
	public AccessFilter accessFilter() {
		
		return new AccessFilter();
	}
}
