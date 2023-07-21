package com.Demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class PropertiesReading {// we cannot define class name as a properties.
	/**
	 * Store laocator and access it by using this method
	 * 
	 * @param key
	 * @return
	 */
	public static String setProperty(String key) {
		String value = null;
		String filePath = "D:\\Eclipse\\Eclipse_Code\\KeywordTestNGFramework\\ObjectRepository\\ObjectRepository.Properties";
		try {// This 4 line of code will helps to read the properties
			FileInputStream File = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(File);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;

	}

	/**
	 * To get credential from application properties.
	 * 
	 * @param key
	 * @return
	 */
	public static String setCredential(String key) {
		String value = null;
		String filePath = "D:\\Eclipse\\Eclipse_Code\\KeywordTestNGFramework\\resources\\application.properties";
		try {// This 4 line of code will helps to read the properties
			FileInputStream File = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(File);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}

	/**
	 * This Method will use to set url for launching.
	 * 
	 * @param key
	 * @param filePath
	 * @return
	 */

	public static String setProperty(String key, String filePath) {
		String value = null;
		
		try {// This 4 line of code will helps to read the properties
			FileInputStream File = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(File);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;

	}

	/**
	 * This Method is use to split locator type and locatoe value inside id##name =
	 * loactor(## seperator)value of locator
	 * 
	 * @param key
	 * @return
	 */
	public static String[] setProperties(String key) {
		String values[] = null;
		String filePath = "D:\\Eclipse\\Eclipse_Code\\DemoFramework\\ObjectRepository\\ObjectRepository.Properties";
		try {

			FileInputStream File = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(File);
			String value = prop.getProperty(key);
			values = value.split("##");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return values;

	}

	@DataProvider(name = "dataprovider")
	public static Object[][] getData(Object key) {
		String filepath = System
				.getProperty(":\\Eclipse\\Eclipse_Code\\DemoFramework\\resources\\dataprovider.properties");

		try {
			FileInputStream File;
			File = new FileInputStream(filepath);
			Properties prop = new Properties();
			prop.load(File);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;

	}
}