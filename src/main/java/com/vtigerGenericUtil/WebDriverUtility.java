package com.vtigerGenericUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public static WebDriver driver;
	
	public void openBrowser(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
			driver = new ChromeDriver();
		}
	}
	
	public void selectByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public void selectByVisibleText(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void mouseOver(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void switchToWindow(WebDriver driver, String partialWindowText)
	{
	  	Set<String> window_ids = driver.getWindowHandles();
	  	Iterator<String> i = window_ids.iterator();
	  	while(i.hasNext())
	  	{
	  		 String parentWindow = i.next();
	  		 String parentTitle = driver.switchTo().window(parentWindow).getTitle();
	  		 if(parentTitle.contains(parentTitle))
	  		 {
	  			 break;
	  		 }
	  		 
	  	}
	}
	public void switchTOFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchTOFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	public String takeScreenShot(WebDriver driver, String ScreenshotName) throws Throwable 
	{
		String screenShotPath = "./ScreenShots/"+ScreenshotName+"/.PNG";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenShotPath);
		Files.copy(src, dest);
		return screenShotPath;
	}
	
	public void alertaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void alertdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void pressEnter(WebDriver driver) throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
}
