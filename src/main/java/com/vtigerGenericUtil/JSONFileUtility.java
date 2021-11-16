package com.vtigerGenericUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	
	public String jsonFileUtility(String key) throws Throwable
	{
		FileReader fr = new FileReader(IPathConts.JSON_PATH);
		JSONParser json = new JSONParser();
		Object obj = json.parse(fr);
		
		HashMap value = (HashMap)obj;
		String key_val = (String) value.get(key);
		return key_val;
	}

}
