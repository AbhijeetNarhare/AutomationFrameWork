package vtiger.campaignTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilties.ExcelFileUtility;
import vtiger.GenericUtilties.PropertyFileUtility;
import vtiger.GenericUtilties.WebDriverUtility;

public class CreateNewCampaign {

	public static void main(String[] args) throws Throwable {
		/*Scenario 2
		Navigate to compaigns link
		Click on Create new campaign
		Create a campaign with following details:
		Choose campaign type as 'Webinar'
		Choose campaign status as 'Active'
		choose a product 
		save campaign and verify*/
		
		
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
		String CAMPAIGN_NAME = eUtil.getDataFromExcelFile("Campaigns", 10, 2);
		String CAMPAIGN_TYPE = eUtil.getDataFromExcelFile("Campaigns", 10, 3);
		String CAMPAIGN_STATUS = eUtil.getDataFromExcelFile("Campaigns", 10, 4);
		String PRODUCT_NAME = eUtil.getDataFromExcelFile("Campaigns", 10, 5);
				
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
		
		//Step 5:click on more module & select camapigns
		WebElement campaign = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wUtil.mouseHoverAction(driver, campaign);
		driver.findElement(By.name("Campaigns")).click();
		
		//Step 6:click on create vendor lookup image
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//Step 7:Create a contact with mandatory information
		driver.findElement(By.name("campaignname")).sendKeys(CAMPAIGN_NAME);
		WebElement Type = driver.findElement(By.name("campaigntype"));
		wUtil.handleDropDown(Type, CAMPAIGN_TYPE);
		
		WebElement Status = driver.findElement(By.name("campaignstatus"));
		wUtil.handleDropDown(Status, CAMPAIGN_STATUS);
		
		driver.findElement(By.xpath("//input[@name='product_name']/following-sibling::img[@title='Select']")).click();
		
		//Step 8: Switch to child window
		wUtil.switchToWindow(driver, "Products");
		  
		  //Step 9:Search for product name
		driver.findElement(By.name("search_text")).sendKeys(PRODUCT_NAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+ PRODUCT_NAME +"']")).click();  //Dynamic path
		
		//Step 8: Switch to parent window
		wUtil.switchToWindow(driver, "Campaigns");
		
		// Step 9: save
		driver.findElement(By.name("button")).click();

		// Step 10: Validate
	   String CampaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(CampaignHeader.contains(CAMPAIGN_NAME))
		{
			System.out.println("pass");
			System.out.println(CampaignHeader);
		}
		else
		{
			System.out.println("fail");
		}
		
		// Step 11: LogOut	
		WebElement AdminTag = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, AdminTag);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("LogOut Successfull");
	}
	

}
