package com.vtigerOrgModuleTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.BaseClass;
import com.vtigerGenericUtil.ExcelUtility;
import com.vtigerGenericUtil.IPathConts;
import com.vtigerGenericUtil.JavaUtility;
import com.vtigerGenericUtil.PropertyFileUtility;
import com.vtigerGenericUtil.WebDriverUtility;

public class CreateOrgWithShippingAddr extends BaseClass {
	
	@Test 
	public void createOrgWithShippingAddrTest() throws Throwable
	{
		// Click on Organization Tab
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		Thread.sleep(5000);
		
		//Click on Create new Organization button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		int num = JavaUtility.randomNum();
		String Org_Name = eutil.readExcelData("Sheet2", 1, 1)+"_"+num;	
		String website = eutil.readExcelData("Sheet2", 2, 1);
		String industry = eutil.readExcelData("Sheet2", 3, 1);
		String billing_addr = eutil.readExcelData("Sheet2", 4, 1);
		WebElement industryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
		
		//Enter all fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Org_Name);
		driver.findElement(By.name("website")).sendKeys(website);		
		wutil.selectByVisibleText(industryDropDown, industry);
		WebElement copyShippinAddr_radioBtn = driver.findElement(By.xpath("(//td/input[@name='cpy'])[1]"));
		boolean flag = copyShippinAddr_radioBtn.isEnabled();
		if(flag==true)
		{
			WebElement ship_Addr_txtArea = driver.findElement(By.xpath("//textarea[@name='bill_street']"));
			ship_Addr_txtArea.sendKeys(billing_addr);
			WebElement copyBillAddr_radioBtn = driver.findElement(By.xpath("(//td/input[@name='cpy'])[2]"));
			copyBillAddr_radioBtn.click();
			
			
		}
		else
		{
			System.out.println("Copy Shipping Address Radio Button is not enabled");
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Organization created");
		Thread.sleep(3000);
		String Org_Info = (driver.findElement(By.xpath("//span[@class='dvHeaderText']"))).getText();
		
		Assert.assertTrue(Org_Info.contains(Org_Name));
		Reporter.log("Verification Done", true);
		Thread.sleep(5000);
		
		
	}

}
