package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	
	@Test
	public void sampleProg()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("your store")) 
		{
			System.out.println("It is verified");
		}else {
			System.out.println("It is not verfied");
		}
		
		WebElement ele=driver.findElement(By.linkText("Components"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Monitors')]")).click();
	    String price1=driver.findElement(By.xpath("//p[contains(text(),'Apple Cinema')]/following-sibling::p/span[@class='price-new']")).getText();
	    System.out.println(price1);
	    driver.findElement(By.xpath("//a[contains(text(),'Apple Cinema')]")).click();
	    String price2=driver.findElement(By.xpath("//a[contains(text(),'Apple Cinema')]/following::h2")).getText();
	    System.out.println(price2); 
	    if(price1.equals(price2))
	    {
	    	System.out.println("same price");
	    }else{
	    	System.out.println("different price");
	    }
	    Point loc=driver.findElement(By.xpath("//h3[text()='Available Options']")).getLocation();
	    int x=loc.getX();
	    int y=loc.getY();
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy("+x+", "+y+")");
	    driver.findElement(By.xpath("//div[contains(@id,'input-option')]/descendant::input[@type='radio']")).click();
	    driver.findElement(By.xpath("//div[@class='form-group required ']/following-sibling::div/descendant::input[@value='10']")).click();
	    WebElement tbox=driver.findElement(By.xpath("//label[text()='Text']/following-sibling::input[@class='form-control']"));
	    tbox.clear();
	    tbox.sendKeys("Selenium4");
	    WebElement sele=driver.findElement(By.xpath("//select[@class='form-control']"));
	    Select sel=new Select(sele);
	    sel.selectByIndex(1);
	    
	    driver.findElement(By.xpath("//button[@id='button-cart']")).click();
	    try {
	    	String txt=driver.findElement(By.xpath("//div[text()='File required']")).getText();
	        if(txt.equals("File required"))
	        {
	        	System.out.println(txt+" message displayed");
	        }
	    }catch(Exception e) {
	    	System.out.println(" message not displayed");
	    }
	    driver.quit();
	
	
	}

}
