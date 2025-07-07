package com.project.hospitalmanagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@ComponentScan("com.project.hospitalmanagementSystem")
@EntityScan("com.project.hospitalmanagementSystem.models")
@EnableJpaRepositories("com.project.hospitalmanagementSystem.repository")
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}
@GetMapping
	public String call(){
		return "hello";}
	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}
}
