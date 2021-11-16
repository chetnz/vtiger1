package PracticeScriptsAmazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.IPathConts;

public class Lenskart {
	
	@Test
	public void lenskartTest() throws Throwable
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lenskart.com/");
		
		String logoToolTip = driver.findElement(By.xpath("//img[@title='Lenskart']")).getAttribute("title");
		System.out.println(logoToolTip);
		
		driver.findElement(By.xpath("//input[@class='search_input-bar autoSuggest']")).click();
		//Thread.sleep(3000);
		List<WebElement> listOfSuggestions = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']//li"));
		
		
		
		
		System.out.println(listOfSuggestions.get(0).getText());
		
		for(int i=1; i<listOfSuggestions.size(); i++)
		{
			System.out.println(listOfSuggestions.get(i).getText());
		}
	}

}
