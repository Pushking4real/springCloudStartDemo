package com.abchina.microservice.edge;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class EdgeMicroserviceResource {
	private final Logger log=Logger.getLogger(getClass());
	@Value("${server.port}")
	private int port;

	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod="helloFallback")
	@GetMapping("/resource")
	public String hello(@RequestParam String name) {
		String result = null;
		//分别请求资源的基本属性及扩张属性
		String resBaseUrl = "http://base-microservice/rest/base/server/baseinfo";
		String resExtUrl = "http://base-microservice/rest/base/server/extvalue";
		//return restTemplate.getForObject(url, String.class) + " including client(on port " + port
		//		+ ").";
		result = "Base Info:" + restTemplate.getForObject(resBaseUrl, String.class);
		result += " Ext Info:" + restTemplate.getForObject(resExtUrl, String.class);
		result += " including edge service (on port " + port + ").";
		result +="<br> hello,"+name;
		return result;
	}
	
	public String helloFallback(@RequestParam String name) {
		return "base-service encountered an error!!!";
		
	}
	
	@HystrixCommand(fallbackMethod="timeoutFallback")
	@GetMapping("/timeout")
	public String timeoutTest() {
		
		String result = null;
		long start=System.currentTimeMillis();
		String ressayhiUrl = "http://base-microservice//helloController/sayhi";
		//return restTemplate.getForObject(url, String.class) + " including client(on port " + port
		//		+ ").";
		
		result += " Ext Info:" + restTemplate.getForObject(ressayhiUrl, String.class);
		result += " including edge service (on port " + port + ").";
		long end=System.currentTimeMillis();
		log.info("time spent:"+(end-start));
		return result;
	}
	
	public String timeoutFallback() {
		return "base-service response timeout!";
		
	}

}
