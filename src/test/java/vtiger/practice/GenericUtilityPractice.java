package vtiger.practice;

import vtiger.GenericUtilties.ExcelFileUtility;
import vtiger.GenericUtilties.JavaUtility;
import vtiger.GenericUtilties.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jUtil = new JavaUtility();
		
		int value = jUtil.getrandomNumber();
		
		System.out.println(value);
		
		System.out.println(jUtil.getSystemDate());
		
        System.out.println(jUtil.getSystemDateInFormat());
		
        PropertyFileUtility pUtil = new PropertyFileUtility();    
        String value1 = pUtil.getDataFromPropertyFile("username");
        System.out.println(value1);
        
        ExcelFileUtility eUtil = new ExcelFileUtility();
        String data = eUtil.getDataFromExcelFile("Organization", 1, 1);
        System.out.println(data);
        
        eUtil.writeDataIntoExcel("Sample2", 1, 2, "Batman");
        System.out.println("data added");
		
	}
	
}
