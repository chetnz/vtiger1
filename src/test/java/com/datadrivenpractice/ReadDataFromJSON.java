package com.datadrivenpractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadDataFromJSON  {
	@Test
	public void readJSONData() throws Throwable
	{
	FileReader fr = new FileReader("./src/main/resources/commonData.json");
	JSONParser json = new JSONParser();
	Object obj = json.parse(fr);
	System.out.println(obj);
	HashMap hp = (HashMap)obj;
	Object URL = hp.get("url");
	Object USERNAME = hp.get("username");
	Object PASSWORD = hp.get("password");
	System.out.println(URL+" "+USERNAME+" "+PASSWORD);
	
	}
	
	
	

}
