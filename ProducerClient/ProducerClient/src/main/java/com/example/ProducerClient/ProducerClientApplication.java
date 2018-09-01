package com.example.ProducerClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.*")
@EnableDiscoveryClient
public class ProducerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerClientApplication.class, args);
	}
}
