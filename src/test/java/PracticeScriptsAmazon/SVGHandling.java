package PracticeScriptsAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.IPathConts;

public class SVGHandling {
	
	@Test 
	public void svgHandleTest()
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.learnatnoon.com/");
		driver.findElement(By.xpath("//*[name()='svg' and @class='icon icon-arrow-down ']")).click();
		driver.findElement(By.xpath("//a[@href='/in-en']")).click();
		
	}

}
