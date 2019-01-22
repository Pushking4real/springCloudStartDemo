package com.abchina.microservice.base;

import java.util.Random;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/helloController")
public class HelloController {
	
	private final Logger log=Logger.getLogger(getClass());
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private Registration registration;
	
	@RequestMapping("/sayhi")
	public String sayhi() throws InterruptedException {
		ServiceInstance instance= (ServiceInstance) client.getInstances(registration.getServiceId()).get(0);
		log.info("request sayhi.....，host："+instance.getHost()+",serviceid:"+instance.getServiceId());
		
		int sleepTime=new Random().nextInt(2500);
		log.info("sleep for:"+sleepTime);
		Thread.sleep(sleepTime);
		return "hello";
		
	}
}
