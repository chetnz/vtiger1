package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrganizationInfo {
	
	public OrganizationInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']") WebElement OrgInfo;
	
	public void verifyOrgInfo(String org_name) throws Throwable
	{
		String orgInfo = OrgInfo.getText();
		Assert.assertTrue(orgInfo.contains(org_name));
		Thread.sleep(5000);
	}
	
	
}
