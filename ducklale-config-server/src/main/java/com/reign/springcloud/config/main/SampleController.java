package com.reign.springcloud.config.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class SampleController{
	
	public static void main(String[] args){
		SpringApplication.run(SampleController.class, args);
	}
}