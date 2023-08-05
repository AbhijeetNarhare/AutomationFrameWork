package vtiger.practice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilties.ExcelFileUtility;
import vtiger.GenericUtilties.JavaUtility;
import vtiger.GenericUtilties.PropertyFileUtility;
import vtiger.GenericUtilties.WebDriverUtility;

public class CreateTheOrgWithIndustryUsingDDT_GU {
	
	public static void main(String[] args) throws Throwable {
		
		//Create object of required Utilities
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
	       WebDriver driver=null;
	       //Step 1: Read all the necessary data
	        
	       /* Read data from property file - common data */
	     String BROWSER = pUtil.getDataFromPropertyFile("browser");
	     String URL = pUtil.getDataFromPropertyFile("url");
	     String USERNAME = pUtil.getDataFromPropertyFile("username");
	     String PASSWORD = pUtil.getDataFromPropertyFile("password");
	       
	       /* Read the data from excel sheet */
	     String ORGNAME = eUtil.getDataFromExcelFile("Organization", 4, 2)+jUtil.getrandomNumber();
	      String INDUSTRY = eUtil.getDataFromExcelFile("Organization", 4, 3);
	       
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
	       wUtil.maximizeWindow(driver);
	       wUtil.waitForElementsToLoad(driver);
	       
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
		
			     
		 //step 8:choose 'chemicals' in drop down
		 WebElement IndustryDropDown = driver.findElement(By.name("industry"));
			wUtil.handleDropDown(IndustryDropDown, INDUSTRY);
			  
		 //step 9:Save
	     driver.findElement(By.name("button")).click();
			     
		 //step 10:Validate
		 String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
			 if( OrgHeader.contains(ORGNAME))
			     {
			    	 System.out.println("pass");
			    	 System.out.println(OrgHeader);
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


