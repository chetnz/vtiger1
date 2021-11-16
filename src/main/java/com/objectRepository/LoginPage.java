package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name") WebElement usernameTxtBox;
	@FindBy(name="user_password") WebElement passwordTxtBox;
	@FindBy(id="submitButton") WebElement loginBtn;
	
	public WebElement getUsernameTxtBox() {
		return usernameTxtBox;
	}
	
	public WebElement getPasswordTxtBox() {
		return passwordTxtBox;
	}
	
	public WebElement getloginBtn() {
		return loginBtn;
	} 

	public void logIntoVtiger(String username, String password)
	{
		usernameTxtBox.sendKeys(username);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		
	}
}
