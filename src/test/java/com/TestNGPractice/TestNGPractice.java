package com.TestNGPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	
	@BeforeSuite
	public void openDBCon()
	{
		System.out.println("Open DB connection");
	}
	
	@BeforeClass
	public void openBrowser()
	{
		System.out.println("Open the Browser");
	}
	
	@BeforeMethod
	public void logIn()
	{
		System.out.println("Log In Application");
	}
	
	
	@Test
	public void createORg()
	{
		System.out.println("create org TC");
	}
	
	@Test
	public void modifyORg()
	{
		System.out.println("modify org TC");
	}
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("Log Out Application");
	}

	@AfterClass
	public void closeBrowser()
	{
		System.out.println("close the Browser");
	}
	
	@AfterSuite
	public void closeDBCon()
	{
		System.out.println("close DB COnnection");
	}
}
