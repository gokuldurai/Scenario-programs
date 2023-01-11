package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Flight {
	
	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void flightDetailsInMakeMyTripTest() throws IOException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\propertyfile.properties");
		Properties p=new Properties();
		p.load(fis);
		String val = p.getProperty("from");
		String to = p.getProperty("to");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(val);
		driver.findElement(By.xpath("//p[text()='"+val+", India']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		driver.findElement(By.xpath("//p[text()='"+to+", India']")).click();
		
		driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--selected']")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		try {
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		}
		catch(Exception e) {
			System.out.println("no popup");
		}
		
		driver.findElement(By.xpath("//div[@class='filtersOuter']/child::p[text()='Popular Filters']/following::div[@class='collapse']/following::span[@class='linkText pointer']")).click();
		List<WebElement> airlines =driver.findElements(By.xpath("//span[.='Show less']/preceding::span[@class='filterName']"));
	  
        for(WebElement flight:airlines) {
			
			String s=flight.getText();
			String num = s.replaceAll("[^0-9]","");
			int n= Integer.parseInt(num);
			
			if(n<=10) {
				flight.click();
				System.out.println(s);
			}		
			
		}
		
		
        List<WebElement> flightname = driver.findElements(By.xpath("//p[@class='boldFont blackText airlineName']"));
        List<WebElement> depature = driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']/child::p[@class='appendBottom2 flightTimeInfo']"));
        List<WebElement> arrival = driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']/child::p[@class='appendBottom2 flightTimeInfo']"));
        List<WebElement> rate = driver.findElements(By.xpath("//div[@class='textRight flexOne']"));
        
      FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\flight.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis1);
		String sheet="airlines";
		Sheet sh=wb.getSheet(sheet);
		for(int i=1;i<flightname.size();i++)
		{
			Row r=sh.createRow(i);
			r.createCell(1).setCellValue(flightname.get(i-1).getText());
			r.createCell(2).setCellValue(depature.get(i-1).getText());
			r.createCell(3).setCellValue(arrival.get(i-1).getText());
			r.createCell(4).setCellValue(rate.get(i-1).getText());
		}
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\flight.xlsx");
		wb.write(fos);
		wb.close();
        
		driver.close();
	}

}
