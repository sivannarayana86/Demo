package com.example.ConsumerClient;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;



@RestController
@RequestMapping("/consumer")
@EnableFeignClients(basePackages = { "com.example.*" })
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Resource
	ProducerClient producerClient;
	
	@Resource
	ConsumerService consumerService;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> read(@PathVariable String name) {
		String message = producerClient.getGreeting(name);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	private static final String baseURL = "http://ProducerClient/producer/";

	@RequestMapping(value = "template/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> readWithTemplate(@PathVariable String name) {
		consumerService.sampleString();
		String message = restTemplate.getForObject(baseURL + "{name}", String.class, name);
		//String greeting =  this.restTemplate.exchange(baseURL + "{name}", HttpMethod.GET, null,new ParameterizedTypeReference<String>() {},"Essaki").getBody();
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "discoveryClient/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> readWithDiscoveryClient(@PathVariable String name) {
      ServiceInstance s = discoveryClient.getInstances("ProducerClient").get(0);
     String baseUrl=s.getUri().toString();
     String message = restTemplate.getForObject(baseUrl + "{name}", String.class, name);
	return new ResponseEntity<>(message, HttpStatus.OK);
	}
	@RequestMapping(value = "loadBalancerClient/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> readWithloadBalancerClient(@PathVariable String name) {
    /*  ServiceInstance s = loadBalancer.choose("ProducerClient");
      String baseUrl=s.getUri().toString();
      System.out.println(s.getServiceId() + ":" + s.getPort());*/
      String message = restTemplate.getForObject(baseURL + "{name}", String.class, name);
	return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "template/user", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> readWithJson() {
		JSONObject message = restTemplate.getForObject(baseURL +"user", JSONObject.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		try {
			writer.writeValue(new File("D:/testJson/dataTwo.json"), message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
