package com.example.ConsumerClient;

import org.json.simple.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("ProducerClient")
public interface ProducerClient {
	@RequestMapping(value = "/producer/{name}", method = RequestMethod.GET)
	String getGreeting(@PathVariable("name") String name);
	@RequestMapping(value = "/producer/user", method = RequestMethod.GET)
	JSONObject jsonObj();  
}
