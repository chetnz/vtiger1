package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtigerGenericUtil.ExcelUtility;
import com.vtigerGenericUtil.JavaUtility;
import com.vtigerGenericUtil.WebDriverUtility;

public class CreateOrganization {
	
	ExcelUtility eutil = new ExcelUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	
	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") WebElement createOrgLink;
	@FindBy(xpath="//input[@name='accountname']") WebElement orgTxtBox;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") WebElement saveBtn;
	@FindBy(xpath="//select[@name='industry']") WebElement industryDropDown;
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	public WebElement getOrgTxtBox() {
		return orgTxtBox;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName) throws Throwable
	{
		createOrgLink.click();
		
		orgTxtBox.sendKeys(orgName);
		saveBtn.click();
		Thread.sleep(4000);
	}
	
	public void createOrgWithIndustry(String orgName,String industry) throws Throwable
	{
		createOrgLink.click();		
		orgTxtBox.sendKeys(orgName);
		wutil.selectByVisibleText(industryDropDown, industry);
		saveBtn.click();
		Thread.sleep(4000);
	}
}
