package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Load the file in java readable format
		//FileInputStream fis=new FileInputStream("C:\\Users\\abhijeet\\Desktop\\Advance se.xls.xlsx");
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\Advance se.xls.xlsx");
		
		//Step 2: Create a workbook for a file
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: Navigate to required Row
		Row rw = sh.getRow(6);
		
		//Step 5: Navigate to required Cell
		Cell ce = rw.getCell(2);
		
		//Step 6: Capture the value inside the cell
		String value = ce.getStringCellValue();
	
		System.out.println(value);
	}

}
