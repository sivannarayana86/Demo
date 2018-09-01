package com.example.ConsumerClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
	private Properties appProperties = new Properties();
	private String propFile = "application.yml";
		
	private static PropertiesReader instance = new PropertiesReader();
	
	private PropertiesReader() {
		try (InputStream in = PropertiesReader.class.getClassLoader().getResourceAsStream(propFile)) {
			appProperties.load(in);
		} catch (IOException e) {
			
		}
	}
	
	public static PropertiesReader getInstance() {
		return instance;
	}

	public Properties getAppProperties() {
		return appProperties;
	}
	
	public String getValue(String key) {
		return appProperties.getProperty(key);
	}
	
	public Set<Object> getKeySet(String key) {
		return appProperties.keySet();
	}
}
