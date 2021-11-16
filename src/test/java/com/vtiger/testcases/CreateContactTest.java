package com.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.IPathConts;
import com.vtigerGenericUtil.PropertyFileUtility;
import com.vtigerGenericUtil.WebDriverUtility;

public class CreateContactTest {
	@Test
	public void createContactTest() throws Throwable
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		PropertyFileUtility pfu = new PropertyFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		String URL = pfu.propertyFileUtility("url");
		String UN = pfu.propertyFileUtility("username");
		String PWD = pfu.propertyFileUtility("password");
		driver.get(URL);
		Thread.sleep(5000);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement salDropDown = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		wutil.selectByVisibleText(salDropDown, "Mr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Abhi1");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Zala");
		driver.findElement(By.xpath("//img[@title='Select' and @src='themes/softed/images/select.gif']")).click();
		wutil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		WebElement LogOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.waitForElementToBeVisible(driver, LogOut);	
		
		wutil.mouseOver(LogOut, driver);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
