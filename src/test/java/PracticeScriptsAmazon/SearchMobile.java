package PracticeScriptsAmazon;

import java.util.List;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.BaseClass;
import com.vtigerGenericUtil.IPathConts;

public class SearchMobile  {
	
	@Test 
	public void searchMobileTest()
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobile under 15000");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("(//span[text()='See more'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='MI']/ancestor::li[@id='p_89/MI']/descendant::i[@class='a-icon a-icon-checkbox']")).click();
		
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		
		
			String firstOption = listOfOptions.get(0).getText();
			//firstOption.click()
			System.out.println(firstOption);
		
		
		
		
	}

}
