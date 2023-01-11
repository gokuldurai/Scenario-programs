package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public void writeMultipleDataIntoExcel(String sheet, int row1, int cel, String value) throws IOException  {
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\flight.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet1 = workbook.getSheetAt(0);
		
		int lastRow = sheet1.getLastRowNum();
		
		for(int i=1; i<=lastRow; i++){
			
			Row row = sheet1.getRow(i);
			
			Cell cell = row.createCell(2);
			
			cell.setCellValue("Writing Done");
			
		}
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\flight.xlsx");
		
		workbook.write(fos);
		
		fos.close();


	}

}
