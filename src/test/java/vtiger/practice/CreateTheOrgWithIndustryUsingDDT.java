package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTheOrgWithIndustryUsingDDT {

	public static void main(String[] args) throws IOException {
		
       WebDriver driver=null;
       Random r = new Random();
       int random = r.nextInt(1000);
       
       //Step 1: Read all the necessary data
        
       /* Read data from property file - common data */
       FileInputStream fisp = new FileInputStream(".\\src\\main\\resources\\data.properties");
       Properties pObj = new Properties();
       pObj.load(fisp);
       String BROWSER = pObj.getProperty("browser");
       String URL = pObj.getProperty("url");
       String USERNAME = pObj.getProperty("username");
       String PASSWORD = pObj.getProperty("password");
       
       /* Read the data from excel sheet */
       FileInputStream fise = new FileInputStream(".\\src\\main\\resources\\Advance se.xls.xlsx");
       Workbook wb = WorkbookFactory.create(fise);
       Sheet sh = wb.getSheet("Organization");
       String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
       String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
       
       //Step 2: Launch the browser - driver is acting based runtime data - RunTime polymorphism
       if(BROWSER.equalsIgnoreCase("chrome"))
       {
    	   WebDriverManager.chromedriver().setup();
    	   driver=new ChromeDriver();
    	   System.out.println(BROWSER+"---Browser launched");
       }
       else if(BROWSER.equalsIgnoreCase("edge"))
       {
    	   WebDriverManager.edgedriver().setup();
    	   driver=new EdgeDriver();
    	   System.out.println(BROWSER+"---Browser launched");   			 
       }
       else 
       {
    	   System.out.println("invalid Browser name");
       }
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
      //Step 3: Load the URL
     		driver.get(URL);
     		
     //step 4:Login to application
   	 driver.findElement(By.cssSelector("[name=\"user_name\"]")).sendKeys(USERNAME);
     driver.findElement(By.cssSelector("[name=\"user_password\"]")).sendKeys(PASSWORD);
     driver.findElement(By.cssSelector("[id=\"submitButton\"]")).click();		
       
     //step 5:click on Organization link
	 driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			 
	 //step 6:click on Create Organization look Up Image 
	 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		     
     //step 7:Create organization
	 
	 driver.findElement(By.cssSelector("[name=\"accountname\"]")).sendKeys(ORGNAME);
	 driver.findElement(By.cssSelector("[name=\"website\"]")).sendKeys("www.Qspiders.com");
		     
	 //step 8:choose 'chemicals' in drop down
	 WebElement industryDropDown = driver.findElement(By.name("industry"));
	 Select s=new Select(industryDropDown);
	 s.selectByValue(INDUSTRY);
		  
	 //step 9:Save
     driver.findElement(By.name("button")).click();
		     
	 //step 10:Validate
	 WebElement OrgHeader1 = driver.findElement(By.xpath("//span[contains(text(),'Qspiders')]"));
	 String headerText2 = OrgHeader1.getText();
		 if( headerText2.contains("Qspiders"))
		     {
		    	 System.out.println("pass");
		    	 System.out.println(headerText2);
		     }
		     else 
		     {
		    	 System.out.println("fail");
		     }
		 
	//step 11:Logout-------------------------------------------------------------------------------------------------
	 WebElement AdminTag = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
	 Actions act = new Actions(driver);
	act.moveToElement(AdminTag).perform();
		     
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		     
	System.out.println("LogOut Successfull");
	}

}
