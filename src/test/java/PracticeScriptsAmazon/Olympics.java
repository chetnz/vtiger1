package PracticeScriptsAmazon;

import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.IPathConts;

public class Olympics {
	@Test
	public void oylmpicsTest()
	{

	System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
	WebDriver driver = new ChromeDriver();
	driver.get("https://olympics.com/");
	
	List<WebElement> names = driver.findElements(By.xpath("//a[@class='featured-athlete__name d-flex text-body']/span"));
	for(int i=1; i<names.size(); i++)
	{
		String athelete = names.get(i).getText();
		WebElement medals = driver.findElement(By.xpath("//span[text()='"+athelete+"']/ancestor::div[@class='featured-athlete__description']/ancestor::div[@class='featured-athlete__wrapper d-flex']/preceding-sibling::div[@class='featured-athlete__medals text-body-sm']"));
		System.out.print(athelete+"/t");
		System.out.println(medals.getText());
	}
	
	int golds = (driver.findElements(By.xpath("//span[@class='result-medal result-medal--gold']"))).size();
	int silver = (driver.findElements(By.xpath("//span[@class='result-medal result-medal--silver']"))).size();
	int bronze = (driver.findElements(By.xpath("//span[@class='result-medal result-medal--bronze']"))).size();
	
	
	

	
}
}
