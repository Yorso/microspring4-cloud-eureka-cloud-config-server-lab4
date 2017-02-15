package com.jorge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Microspring4EurekaDiscoveryClientLab4Application{ 

	public static void main(String[] args) {
		SpringApplication.run(Microspring4EurekaDiscoveryClientLab4Application.class, args);
	}
}
