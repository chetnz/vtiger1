package com.datadrivenpractice;

import org.testng.annotations.Test;

public class ReadFromCmdLineTest {
	
	@Test
	public void ReadFromCMD()
	{
		String URL = System.getProperty("url");
	String UN = System.getProperty("username");
	String PWD = System.getProperty("password");
	
	System.out.println(URL+" "+UN+" "+PWD);
		
	}

}
