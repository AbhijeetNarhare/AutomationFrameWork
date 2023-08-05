package vtiger.vendorTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilties.ExcelFileUtility;
import vtiger.GenericUtilties.PropertyFileUtility;
import vtiger.GenericUtilties.WebDriverUtility;

public class CreateVendor {


	public static void main(String[] args) throws Throwable {
		
		
		//Create object of required utilities
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		WebDriver driver=null;
		
		/*Read all the necessary data*/
		
		/* Read data from property File - Common Data */    
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		/*Read data from excel sheet */
		String VENDOR_NAME = eUtil.getDataFromExcelFile("VENDORS", 1, 2);
				
		//Step 2: Launch the Browser- driver is acting based runtime data - RunTime polymorphism
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"-----------Browser launched");
			
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"-----------Browser launched");
		}
		else
		{
		   System.out.println("invalid browser name");	
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//Step 3:Load the URL
		driver.get(URL);
				
		 //step 4:Login to application
		driver.findElement(By.cssSelector("[name=\"user_name\"]")).sendKeys(USERNAME);
	    driver.findElement(By.cssSelector("[name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.cssSelector("[id=\"submitButton\"]")).click();	
		
		/*------------------Create new vendor---------------------------------------------------------------*/
		//Step 5:click on more module
		WebElement Vendor = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wUtil.mouseHoverAction(driver, Vendor);
		 
		driver.findElement(By.name("Vendors")).click();
		
		//Step 6:click on create vendor lookup image
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		
		//Step 7:Create a contact with mandatory information
		driver.findElement(By.name("vendorname")).sendKeys(VENDOR_NAME);
		
		// Step 8: save
		driver.findElement(By.name("button")).click();
		
		// Step 9:validate
		 String vendorHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 if (vendorHeader.contains(VENDOR_NAME))
		 {
			 System.out.println("pass");
			 System.out.println(vendorHeader);
		 }
		 else
		 {
			 System.out.println("fail"); 
		 }
		
		//step 11:Logout-------------------------------------------------------------------------------------------------
		 WebElement AdminTag = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wUtil.mouseHoverAction(driver, AdminTag);
			     
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			     
		System.out.println("LogOut Successfull"); 
	}
}
