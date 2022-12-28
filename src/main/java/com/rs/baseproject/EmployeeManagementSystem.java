package com.rs.baseproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class EmployeeManagementSystem {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystem.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	//Do Api Testing First
	
    // Api testing done
}
