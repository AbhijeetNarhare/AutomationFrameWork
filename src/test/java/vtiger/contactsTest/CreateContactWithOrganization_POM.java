package vtiger.contactsTest;

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

public class CreateContactWithOrganization_POM {

	public static void main(String[] args) throws Throwable {
/*Create Organization*/
		
		//Create object of required Utilities
	     JavaUtility jUtil=new JavaUtility();
	     PropertyFileUtility pUtil=new PropertyFileUtility();
	     ExcelFileUtility eUtil=new ExcelFileUtility();
	     WebDriverUtility wUtil=new WebDriverUtility();
			 
		WebDriver driver=null;	 
	     
		// Step 1: Read all the necessary data

		/* Read data from property File - Common Data */    
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		/*Read data from excel sheet */
		String ORGNAME = eUtil.getDataFromExcelFile("Contacts", 4, 3)+jUtil.getrandomNumber();
		String LASTNAME =eUtil.getDataFromExcelFile("Contacts", 4, 2);
		
		//Step 2: Launch the Browser- driver is acting based runtime data - RunTime polymorphism
		
		if(BROWSER.equalsIgnoreCase("chroome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"-------Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"-------Browser launched");
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
	       
	     //step 5:click on Organization link
		 driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
				 
		 //step 6:click on Create Organization look Up Image 
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			     
	     //step 7:Create organization
		 
		 driver.findElement(By.cssSelector("[name=\"accountname\"]")).sendKeys(ORGNAME);
		 
		 //step 8:Save
	     driver.findElement(By.name("button")).click();
			     
		 //step 9:Validate
		 String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
			 if( OrgHeader.contains(ORGNAME))
			     {
			    	 System.out.println("Organization Created");
			    	 System.out.println(OrgHeader);
			     }
			     else 
			     {
			    	 System.out.println("fail");
			     }
		
		//Step 10:click on contact link
	    driver.findElement(By.linkText("Contacts")).click();
			
			
	   //Step 11:Navigate to create contact look up image	
		 driver.findElement(By.xpath("//img [@title='Create Contact...']")).click();
		
	  // step 12: Create a contact with mandatory information
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
	//Step 13: Switch to child window
		wUtil.switchToWindow(driver, "Accounts");
		
		// Step 14: search for Organization
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ ORGNAME +"']")).click();  //// dynamic xpath
		
		// Step 15: switch the control back to parent window	
		wUtil.switchToWindow(driver, "Contacts");
		
		// Step 16: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// Step 17:Validation
		 
		 String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 
			 if( ContactHeader.contains(LASTNAME))
			     {
			    	 System.out.println("pass");
			    	 System.out.println(ContactHeader);
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


