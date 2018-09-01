package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;



@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
    private UserService userService;


	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public ResponseEntity<List<User>> allUsers() {
		List<User> users = userService.listAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
}
