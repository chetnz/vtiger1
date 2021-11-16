package com.vtigerGenericUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.vtigerGenericUtil.IPathConts;
public class PropertyFileUtility {

	
	public String propertyFileUtility(String key) throws IOException  
	{
	 FileInputStream fis = new FileInputStream(IPathConts.PROPERTY_PATH);
	 Properties prop = new Properties();
	 prop.load(fis);
	 String KEY = prop.getProperty(key);
	 return KEY;
	}
}
