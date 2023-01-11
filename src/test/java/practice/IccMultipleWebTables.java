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

public class IccMultipleWebTables {
	@Test
	public void webTableTest(){
	ChromeOptions option=new ChromeOptions();
	option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.icc-cricket.com/rankings/mens/player-rankings/t20i");
	
	 WebElement player = driver.findElement(By.xpath("//div[@data-title='T20I Bowling Rankings']/child::table[@class='table rankings-card-table']/tbody/tr[4]/td[2]"));
	 System.out.println(player.getText());
	 
	 
	  List<WebElement> playername = driver.findElements(By.xpath("//div[@data-title='T20I Bowling Rankings']/child::table[@class='table rankings-card-table']/tbody/tr[*]/td[2]"));
//	  for(int i=0;i<playername.size();i++)
//	  {
//		 System.out.println(playername.get(i).getText()); 
//	  }
	  List<WebElement> ratings = driver.findElements(By.xpath("//div[@data-title='T20I Bowling Rankings']/child::table[@class='table rankings-card-table']/tbody/tr/td[4]"));
	  for(int i=0;i<playername.size();i++)
	  {
		  if(playername.get(i).getText().equalsIgnoreCase("Adam Zampa"))
		  {
			  System.out.println(playername.get(i).getText()+" "+ratings.get(i).getText());
		  }
	  }

}
	
	
	@Test(invocationCount=0)
	public void webTableTestAll(){
	ChromeOptions option=new ChromeOptions();
	option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.icc-cricket.com/rankings/mens/overview");
	
	
	List<WebElement> p =driver.findElements(By.xpath("//div[@data-title='ODI Bowling Rankings']/child::table[@class='table rankings-card-table']/tbody/tr/td[2]"));
	 for(int i=0;i<p.size();i++)
		  {
			 System.out.println(p.get(i).getText()); 
		  }
}
}