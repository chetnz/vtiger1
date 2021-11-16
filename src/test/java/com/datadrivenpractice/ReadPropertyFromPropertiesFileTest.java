package com.datadrivenpractice;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;



public class ReadPropertyFromPropertiesFileTest {
	
	@Test
	public void readProperty() throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\nchet\\eclipse-workspace\\SDET_mvnProj\\src\\main\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url", "Incorrect Key");
		String UN = prop.getProperty("username", "Incorrect Key");
		String PWD = prop.getProperty("password", "Incorrect Key");
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
		
	}
	

}
