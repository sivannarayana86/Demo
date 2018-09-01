package com.example.consumerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.example.*")
@EnableFeignClients(basePackages = { "com.example.*" })
@EnableCircuitBreaker
public class ConsumerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerClientApplication.class, args);
	}
}
