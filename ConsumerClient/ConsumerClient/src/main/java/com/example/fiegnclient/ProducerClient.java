package com.example.fiegnclient;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;

@FeignClient("ProducerClient")
public interface ProducerClient {
	@RequestMapping(value = "/user_service/user/", method = RequestMethod.GET)
	List<User> listAllUsers();
}
