package com.sortly.automation.fileutils;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {
	private static final String filePath = "src/test/resources/properties/config.properties";

	public static String getPropertyDetails(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(filePath));
			return prop.getProperty(key).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}