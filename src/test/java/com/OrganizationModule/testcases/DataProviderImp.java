package com.OrganizationModule.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderImp {
	@DataProvider 
	public Object[][] sendData()
	{
		Object[][] ob = new Object[3][2];
		ob[0][0] = "Chetna";
		ob[0][1] = "8780";
		
		ob[1][0] = "Abhi";
		ob[1][1] = "88780";
		
		ob[2][0] = "Yetarth";
		ob[2][1] = "7887";
		return ob;
	}
	@Test(dataProvider="sendData")
	public void getData(String name, String bal)
	{
		System.out.println("Name:"+name+" Balance: "+bal);
	}

}
