package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.ExcelUtility;
import com.vtigerGenericUtil.IPathConts;
import com.vtigerGenericUtil.JavaUtility;
import com.vtigerGenericUtil.PropertyFileUtility;
import com.vtigerGenericUtil.WebDriverUtility;

public class LoginTest implements IPathConts {
	@Test
	public void loginTest() throws Throwable
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		PropertyFileUtility pfu = new PropertyFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		ExcelUtility eutil = new ExcelUtility();
		wutil.openBrowser("browser");
		String URL = pfu.propertyFileUtility("url");
		String UN = pfu.propertyFileUtility("username");
		String PWD = pfu.propertyFileUtility("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		int num = JavaUtility.randomNum();
		String Org_Name = eutil.readExcelData("Sheet1", 1, 2)+"_"+num;
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Org_Name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		WebElement LogOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.waitForElementToBeVisible(driver, LogOut);	
		
		wutil.mouseOver(LogOut, driver);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		
	}

}
