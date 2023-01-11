package redbus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCFlight {
	
	@Test
	public void irctcFlightTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.air.irctc.co.in/");
		
		driver.findElement(By.xpath("//input[@id='stationFrom']")).sendKeys("coimbatore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']/parent::ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/descendant::div[@class='ui-menu-item-wrapper']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='To']")).sendKeys("chennai");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']/parent::ul[@id='ui-id-2']/descendant::div[@class='ui-menu-item-wrapper']")).click();
		driver.findElement(By.xpath("//span[@class='act active-red']")).click();
		driver.findElement(By.xpath("//button[text()='Search ']")).click();
	}

}
