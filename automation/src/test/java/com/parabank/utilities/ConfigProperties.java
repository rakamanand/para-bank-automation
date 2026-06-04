package com.parabank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	private static Properties properties;
	
	static {
		try {
			FileInputStream fs = new FileInputStream("src/test/resources/config.properties");
			properties = new Properties();
			properties.load(fs);
		}
			catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
