package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoviesName {

	@Test
	public void bookMyShowTest() throws EncryptedDocumentException, IOException {
		
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
		
		
		List<WebElement> name = driver.findElements(By.xpath("//a[@class='__venue-name']"));
		List<WebElement> date = driver.findElements(By.xpath("//a[@class='__venue-name']/ancestor::li[@class='list']/descendant::a[@class='showtime-pill']"));
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\movies.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		String sheet="movie";
		Sheet sh=wb.getSheet(sheet);
		for(int i=1;i<name.size();i++)
		{
			Row r=sh.createRow(i);
			r.createCell(1).setCellValue(name.get(i-1).getText());
			r.createCell(2).setCellValue(date.get(i-1).getText());
		}
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\movies.xlsx");
		wb.write(fos);
		wb.close();
		
	}


}
