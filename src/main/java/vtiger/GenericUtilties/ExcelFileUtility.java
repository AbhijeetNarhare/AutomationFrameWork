package vtiger.GenericUtilties;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of generic method related to Excel file
 * @author abhijeet
 *
 */

public class ExcelFileUtility {
	
	/**
	 * This method will reads Data from Excel sheet of sheet name,row no and cell no. given by caller
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcelFile(String sheetName,int rowNo,int celNo) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(Iconstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
	}

	/**
	 * This method will write data into excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName,int rowNo,int celNo,String data) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(Iconstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(celNo);
		cl.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(Iconstants.excelFilePath);
		wb.write(fos); //action
		wb.close();
	}
	
	/**
	 * This method will read all the data inside a sheet to used in data Provider
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Iconstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastcel=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastcel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastcel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

