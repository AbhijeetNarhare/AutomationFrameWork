package vtiger.opportunitiesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilties.ExcelFileUtility;
import vtiger.GenericUtilties.PropertyFileUtility;
import vtiger.GenericUtilties.WebDriverUtility;

public class CreateOpportunityWithContact {
	
	/*Scenario 4: - end to end - Integration - Create Opportunity with Contact
	Launch Browser
	Login to application with valid credentials
	Navigate to Opportunities link
	Click on Create Opportunity look up image
	Create Opportunity with manadatory fields
	Select the Contacts from Related To drop down
	Select the contact Created
	Save and verify
	logout of app */

	public static void main(String[] args) throws Throwable {
		//Create object of required Utilities
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
				String OPPORTUNITI_NAME = eUtil.getDataFromExcelFile("Opportunities", 4, 2);
				String RELATED_TYPE = eUtil.getDataFromExcelFile("Opportunities", 4, 3);
				String LASTNAME = eUtil.getDataFromExcelFile("Contacts", 4, 2);
				
						
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
					
  	        //step 5:Navigate to Opportunities link
			driver.findElement(By.linkText("Opportunities")).click();
			
	       //step 6:Click on Create Opportunity look up image
			driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			
		   //step 7:Create Opportunity with manadatory fields
			driver.findElement(By.name("potentialname")).sendKeys(OPPORTUNITI_NAME);
			WebElement RelatedToTYpe = driver.findElement(By.id("related_to_type"));
			wUtil.handleDropDown(RelatedToTYpe, RELATED_TYPE );
			driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img[@title='Select']")).click();
			
			//step 8:switch to child window
			wUtil.switchToWindow(driver, "Contacts");
			
			driver.findElement(By.name("search_text")).sendKeys(LASTNAME);
			
			WebElement selectContByLastName = driver.findElement(By.xpath("//select[@name='search_field']"));
			wUtil.handleDropDown(selectContByLastName,"Last Name");
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
			
			//step 10:switch to parent window
			wUtil.switchToWindow(driver, "Potentials");
			
			
			
		   //Select the Contacts from Related To drop down
		   //Select the contact Created		

	}

}
