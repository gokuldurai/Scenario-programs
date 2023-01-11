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

public class FlipkartTest {
	@Test
	public void flipkartTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		 
		 WebElement ele = driver.findElement(By.xpath("//div[text()='Electronics']"));
		 Actions a = new Actions(driver);
		 a.moveToElement(ele).perform();
		 
       driver.findElement(By.xpath("//a[text()='Gaming']")).click();
       driver.findElement(By.xpath("//div[@class='CXW8mj']/child::img[contains(@alt,'Arctic Fox Wired USB Gaming Mouse')]")).click();
		 
			Set<String> windowsId = driver.getWindowHandles();
			Iterator<String> it=windowsId.iterator();
			String parent=it.next();
			String child=it.next();
			driver.switchTo().window(child);
			
			WebElement text = driver.findElement(By.xpath("//div[@class='_3k-BhJ']/ancestor::div[@class='_1UhVsV _3AsE0T']"));
	         System.out.println(text.getText());
	
	}
}
