package com.vtiger.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.ExcelUtility;
import com.vtigerGenericUtil.IPathConts;
import com.vtigerGenericUtil.PropertyFileUtility;
import com.vtigerGenericUtil.WebDriverUtility;

public class WebTableOrg {

	@Test 
	public void webTableHandleTest() throws Throwable
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		PropertyFileUtility pfu = new PropertyFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		ExcelUtility eutil = new ExcelUtility();
		String URL = pfu.propertyFileUtility("url");
		String UN = pfu.propertyFileUtility("username");
		String PWD = pfu.propertyFileUtility("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		List<WebElement> listOfOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
		List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		for(int i=1; i<listOfOrg.size(); i++)
		{
			if(listOfOrg.get(i).getText().equalsIgnoreCase("Delta"))
			{
				checkboxes.get(i).click();
				driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
				driver.switchTo().alert().accept();
			}

		}
		
		/*for(int i=1; i<checkboxes.size(); i++)
		{
			checkboxes.get(i).click();

		}*/
		


	}

}
