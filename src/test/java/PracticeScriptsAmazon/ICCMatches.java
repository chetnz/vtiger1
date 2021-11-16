package PracticeScriptsAmazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.IPathConts;

public class ICCMatches {
	
	@Test
	public void iccMatchesTest()
	{
		System.setProperty(IPathConts.CHROME_VALUE, IPathConts.CHROME_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3]"));
		HashMap<String, Integer> hp = new HashMap<String, Integer>();
		
		for(int i=1; i<teams.size(); i++)
		{
			int matches_int = Integer.parseInt(matches.get(i).getText());
			String team_name = teams.get(i).getText();
			hp.put(team_name, matches_int);
			
		}
		
		int maxValueinMap = (Collections.max(hp.values()));
		for(Entry<String, Integer> entry:hp.entrySet())
		{
			if(entry.getValue()==maxValueinMap)
			{
			System.out.println(entry.getKey()+" "+entry.getValue());	
			}
		}
	}

}
