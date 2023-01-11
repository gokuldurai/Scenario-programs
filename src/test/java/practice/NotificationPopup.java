package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationPopup {
	
	@Test
	public void handlePopup() {
	
	
	ChromeOptions options=new ChromeOptions();
	//options.addArguments("--disable-notifications");
	options.addArguments("use-fake-ui-for-media-stream");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	driver.get("https://mictests.com/");
	driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
	
	driver.findElement(By.name("mic_name")).sendKeys("abc");
	

}
}