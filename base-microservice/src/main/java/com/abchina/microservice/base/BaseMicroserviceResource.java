package com.abchina.microservice.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/base/server")
public class BaseMicroserviceResource {
	
	@Value("${server.port}")
	private int port;
	
    @GetMapping("/baseinfo")
    public String resourceBaseInfo() {
        return "Resource Base Info ! (server port + " + port + "). ";
    }
    
    @GetMapping("/extvalue")
    public String resourceExtValue() {
        return "Resource Ext Value! (server port + " + port + "). ";
    }

}
