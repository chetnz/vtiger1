package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigerGenericUtil.WebDriverUtility;

public class HomePage {
	
	WebDriverUtility wutil = new WebDriverUtility();
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']") WebElement OrgLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") WebElement logOutLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") WebElement AdministratorLink;

	public WebElement getOrgLink() {
		return OrgLink;
	}
	public void clickOnOrgLink()
	{
		OrgLink.click();
	}
	public void logOutFromVtiger(WebDriver driver) throws Throwable
	{
		
		
		wutil.mouseOver(AdministratorLink, driver);
		Thread.sleep(4000);
		logOutLink.click();
	}
	

}
