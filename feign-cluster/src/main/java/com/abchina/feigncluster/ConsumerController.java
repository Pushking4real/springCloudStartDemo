package com.abchina.feigncluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ConsumerController {
	@Autowired
	EdgeServices edgeService;
	
	@RequestMapping(value="/feign-consumer",method=RequestMethod.GET)
	public ResponseEntity<byte[]> edgeConsumer() {
		return edgeService.invoke("Pushking");
	}
}
