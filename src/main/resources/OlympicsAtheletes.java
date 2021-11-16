import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtigerGenericUtil.IPathConts;

public class OlympicsAtheletes {
	
	@Test
	public void oympicsAthelesTest()
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/");
		names=driver.findElements(By.xpath("//a[@class='featured-athlete__name d-flex text-body']/span"));
		
	
		
		driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li[1]/descendant::span[@class='result-medal result-medal--gold']"))
	}

}
