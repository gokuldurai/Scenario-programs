package practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccWebTable {
	
	@Test
	public void webTableTest(){
	ChromeOptions option=new ChromeOptions();
	option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	
//	WebElement value = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]"));
//	System.out.println(value.getText());
	 List<WebElement> players = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]"));
	 List<WebElement> points = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[4]"));
//	 for(int i=0; i<players.size();i++) {
//		 if(players.get(i).getText().equalsIgnoreCase("Sri Lanka")) {
//	System.out.println(points.get(i).getText());
// }
     for(int i=0;i<players.size();i++) {
    	 System.out.println(players.get(i).getText()+"==="+points.get(i).getText());
	
	}
 driver.close();
}
}
