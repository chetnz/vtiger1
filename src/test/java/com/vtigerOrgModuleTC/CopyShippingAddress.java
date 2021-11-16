package com.vtigerOrgModuleTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.ExcelUtility;
import com.vtigerGenericUtil.IPathConts;
import com.vtigerGenericUtil.JavaUtility;
import com.vtigerGenericUtil.PropertyFileUtility;
import com.vtigerGenericUtil.WebDriverUtility;

public class CopyShippingAddress {
	@Test
	public void copySHippingAddressTest() throws Throwable
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
		WebElement un_txtBox = driver.findElement(By.name("user_name"));
		WebElement pwd_txtBox = driver.findElement(By.name("user_password"));
		un_txtBox.sendKeys(UN);
		pwd_txtBox.sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		int num = JavaUtility.randomNum();
		String Org_Name = eutil.readExcelData("Sheet1", 1, 2)+"_"+num;		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Org_Name);
		Thread.sleep(2000);
		WebElement copyShippinAddr_radioBtn = driver.findElement(By.xpath("(//td/input[@name='cpy'])[1]"));
		boolean flag = copyShippinAddr_radioBtn.isEnabled();
		if(flag==true)
		{
			System.out.println("Copy Shipping Radio Button is enabled");
		}
		else
		{
			System.out.println("Copy Shipping Address Radio Button is not enabled");
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		WebElement LogOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.waitForElementToBeVisible(driver, LogOut);	
		
		wutil.mouseOver(LogOut, driver);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
	}

}
