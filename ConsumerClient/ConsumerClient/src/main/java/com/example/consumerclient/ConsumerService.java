package com.example.ConsumerClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@Value("${samplestring.test:}")
	private String name;
	
	public void sampleString(){
		System.out.println(name);
		System.out.println(name);
		System.out.println(PropertiesReader.getInstance().getValue("samplestring-test"));
		System.out.println(PropertiesReader.getInstance().getValue("samplestring-test"));
	}
}
