package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTube {
	@Test
	public void playMusic() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		
		//driver.findElement(By.xpath("//input[@id='search']")).sendKeys("hosanna tamil songs");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementByXpath('//input[@id='search']').value='hosanna'");
		
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']")).click();
		driver.close();
	}

}
