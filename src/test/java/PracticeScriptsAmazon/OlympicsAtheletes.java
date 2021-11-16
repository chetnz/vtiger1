package PracticeScriptsAmazon;

import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.IPathConts;

public class OlympicsAtheletes {
	
	@Test
	public void oympicsAthelesTest()
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/");
		List<WebElement> names = driver.findElements(By.xpath("//a[@class='featured-athlete__name d-flex text-body']/span"));
		
	
		for(int i=0; i<names.size(); i++)
		{
			String atheletes = names.get(i).getText();
			if(atheletes.equals("Eliud KIPCHOGE"))
			{
			WebElement gold = driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li[1]/descendant::span[@class='result-medal result-medal--gold']"));
			WebElement silver = driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li[1]/descendant::span[@class='result-medal result-medal--silver']"));
			WebElement bronze = driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li[1]/descendant::span[@class='result-medal result-medal--bronze']"));
			System.out.println("=================Eliud KIPCHOGE===================");
			System.out.println("Gold medals:"+gold.getText()+"  Silver Medals:"+silver.getText()+"    Bronze Medals:"+bronze.getText());
			}
			else if(atheletes.equals("Eliud KIPCHOGE"))
			{
				WebElement gold = driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li[1]/descendant::span[@class='result-medal result-medal--gold']"));
				WebElement silver = driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li[1]/descendant::span[@class='result-medal result-medal--silver']"));
				WebElement bronze = driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::li[1]/descendant::span[@class='result-medal result-medal--bronze']"));
				System.out.println("=================Eliud KIPCHOGE===================");
				System.out.println("Gold medals:"+gold.getText()+"  Silver Medals:"+silver.getText()+"    Bronze Medals:"+bronze.getText());
				
			}
	}
	}


}
