package com.ProductBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductBackEndApplication.class, args);
	}

}
