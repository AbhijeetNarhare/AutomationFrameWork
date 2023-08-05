package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Load the file in java readable format
		FileInputStream fis=new FileInputStream("C:\\Users\\abhijeet\\Desktop\\Advance se.xls.xlsx");
				
		//Step 2: Create a workbook for a file
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step 3: Create sheet
		Sheet sh = wb.createSheet("Trial");
				
		//Step 4: Create Row
		Row rw = sh.createRow(4);
				
		//Step 5: Create Cell
		Cell ce = rw.createCell(6);
				
		//Step 6: Set the value inside the cell
		 ce.setCellValue("Spiderman");
		
		//Step 7: Open the file in java write format
		 FileOutputStream fos=new FileOutputStream("C:\\Users\\abhijeet\\Desktop\\Advance se.xls.xlsx"); 
		
		//Step 8: cell the write method
		 wb.write(fos);
		 System.out.println("data added");
		 
		//Step 9: close the work Book
         wb.close();
         System.out.println("workbook closed");
         
         
	}

}
