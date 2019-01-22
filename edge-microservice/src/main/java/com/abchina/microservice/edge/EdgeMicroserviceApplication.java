package com.abchina.microservice.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class EdgeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeMicroserviceApplication.class, args);
	}
}

@Configuration
class Config {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
//	 @Bean
//	    public ServletRegistrationBean getServlet(){
//	        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//	        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//	        registrationBean.setLoadOnStartup(1);
//	        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//	        registrationBean.setName("HystrixMetricsStreamServlet");
//	        return registrationBean;
//	    }

}