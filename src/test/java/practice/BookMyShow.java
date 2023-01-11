package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {
	
	
	@Test
	public void bookMyShowTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://in.bookmyshow.com");
		
		driver.findElement(By.xpath("//img[@alt='BANG']")).click();
		driver.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
		driver.findElement(By.xpath("//div[@class='sc-jTzLTM sc-cfWELz ggLWHF']/child::input[@type='text']")).sendKeys("Devotion");
		driver.findElement(By.xpath("//li[@class='sc-gJqsIT jMjMYb']")).click();
		
		driver.findElement(By.xpath("//section[@class='styles__BannerFullWidthWrapper-sc-qswwm9-0 bfMWFY']/descendant::div[@id='page-cta-container']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='venuelist']/descendant::a"));
		 for(int i=0;i<list.size();i++)
		 {
			 System.out.println(list.get(i).getText());   
		 }
		
	}

}
