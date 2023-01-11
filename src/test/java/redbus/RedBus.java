package redbus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	@Test
	public void sourceAndDestinationTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//span[@class='fl icon-city icon']/following::input[@type='text']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/child::li[@select-id='results[0]']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("coimbatore");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/child::li[@select-id='results[0]']")).click();
		driver.findElement(By.xpath("//td[@class='current day']")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(1000,4000)");
		
			List<WebElement> allBusses = driver.findElements(By.xpath("//div[@scrollthreshold='1']"));
			
			for(int i=0;i<allBusses.size();i++)
			{
			
		List<WebElement> bus=driver.findElements(By.xpath("//div[@class='column-two p-right-10 w-30 fl']/child::div[@class='travels lh-24 f-bold d-color']/following::div[@class='travels lh-24 f-bold d-color']"));
			{
				for(int j=0;j<bus.size();j++)
				{
					System.out.println(bus.get(j).getText());
				}
			}
		}
			driver.close();
	}

}
