package com.abchina.feigncluster;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("EDGE-MICROSERVICE")
public interface EdgeServices {
	
	@RequestMapping("/rest/resource")
	ResponseEntity<byte[]> invoke(@RequestParam("name") String name);
}
