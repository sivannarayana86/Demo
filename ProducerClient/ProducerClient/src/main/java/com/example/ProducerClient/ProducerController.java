package com.example.ProducerClient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> read(@PathVariable String name) {
		JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", 100);
        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");
        obj.put("messages", list);
		 String message = obj.toString() ;
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/user", method = RequestMethod.GET , produces="application/json")
	public ResponseEntity<JSONObject> readUser() {
		JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", 100);
        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");
        obj.put("messages", list);
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
