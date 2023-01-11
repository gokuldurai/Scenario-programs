package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripSample {
	@Test
	public void makeMyTrip() throws EncryptedDocumentException, IOException, InterruptedException
	{  
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\propertyfile.properties");
		Properties p=new Properties();
		p.load(fis);
		String val = p.getProperty("from");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		try {
			 driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
			// driver.findElement(By.xpath("//div[@class='wrapper']/descendant::a[@class='close']")).click();
			   
		}catch(Exception e) {
			System.out.println("exception");
		}
		
		Thread.sleep(8000);
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(val);
		driver.findElement(By.xpath("//p[text()='"+val+", India']")).click();
		Actions a=new Actions(driver);
		a.moveByOffset(10,10).perform();
		driver.close();	
	}

}
