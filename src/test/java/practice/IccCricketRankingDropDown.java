package practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccCricketRankingDropDown {
	@Test
	public void rankingDropDown(){
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.t20worldcup.com/");
		
		driver.findElement(By.partialLinkText("ICC RANKINGS")).click();
        Set<String> windowIds= driver.getWindowHandles();
		
		Iterator<String> it=windowIds.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
	    WebElement ranking = driver.findElement(By.xpath("//button[contains(text(),'Rankings')][1]"));
		
		Actions a=new Actions(driver);
		a.moveToElement(ranking).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Player Rankings')][1]")).click();
		driver.quit();
	}

}
