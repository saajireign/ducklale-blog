package com.ducklale.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Service
public class DucklaleWebTestService {
    @Autowired
    RestTemplate restTemplate;
    final String SERVICE_NAME="cloud-user-service";
//    @HystrixCommand(fallbackMethod = "fallbackSearchAll")
    @HystrixCommand
    public String getTest(){
        return restTemplate.getForObject("http://"+SERVICE_NAME+"/test",String.class);
    }
    private String fallbackSearchAll(){
        return "server was fucked";
    }
}
