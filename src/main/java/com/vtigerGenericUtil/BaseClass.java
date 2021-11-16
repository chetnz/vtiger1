package com.vtigerGenericUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;

public class BaseClass {
	
	public WebDriverUtility wutil = new WebDriverUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public JSONFileUtility jsonUtil = new JSONFileUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeClass(groups= {"SmokeTest", "RegressionTest"})
	public void openBrowser() throws Throwable
	{
		String BROWSER = putil.propertyFileUtility("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			System.setProperty(IPathConts.GECKO_VALUE, IPathConts.GECKO_PATH);
			driver = new FirefoxDriver();
		}
				
		sdriver=driver;
	}
	
	@BeforeMethod (groups= {"SmokeTest", "RegressionTest"})
	public void logIn() throws Throwable
	{
		String URL = putil.propertyFileUtility("url");
		driver.get(URL);
		String UN = putil.propertyFileUtility("username");
		String PWD = putil.propertyFileUtility("password");
		LoginPage lp=new LoginPage(driver);
		lp.logIntoVtiger(UN, PWD);
	}
	
	
	
	
	@AfterMethod (groups= {"SmokeTest", "RegressionTest"})
	public void logOut() throws Throwable
	{
		Thread.sleep(3000);
		HomePage hp = new HomePage(driver);
		hp.logOutFromVtiger(driver);
	}
	@AfterClass (groups= {"SmokeTest", "RegressionTest"})
	public void closeBrowser()
	{
		driver.close();
	}

}
