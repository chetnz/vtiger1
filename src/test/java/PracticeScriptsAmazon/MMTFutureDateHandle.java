package PracticeScriptsAmazon;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.IPathConts;

public class MMTFutureDateHandle {
	
	@Test
	public void mmtFutureDateHandleTest() throws Throwable
	{
	
	System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
	Date date = new Date();
	String d = date.toString();
	String[] arr = d.split(" ");
	String day = arr[0];
	String month = arr[1];
	String currentDate = arr[2];
	String year = arr[5];
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();;
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	
	driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//div[contains(text(),'HYD')])")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
	
	//driver.findElement(By.xpath("//label[@for='departure']")).click();
	
	for(int i = 0; i<11; i++)
	{
		try
		{
			driver.findElement(By.xpath("//div[@aria-label='Wed Apr 20 2022']")).click();
		}
		
		catch(Exception e)
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}

	
	}

}

