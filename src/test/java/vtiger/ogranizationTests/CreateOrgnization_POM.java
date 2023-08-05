package vtiger.ogranizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import vtiger.GenericUtilties.ExcelFileUtility;
import vtiger.GenericUtilties.JavaUtility;
import vtiger.GenericUtilties.PropertyFileUtility;
import vtiger.GenericUtilties.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgnization_POM {
	public static void main(String[] args) throws Throwable {
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
		String ORGNAME = eUtil.getDataFromExcelFile("Organizations", 10, 2)+jUtil.getrandomNumber();
		String INDUSTRY = eUtil.getDataFromExcelFile("Organizations", 10, 3);		
		
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
				LoginPage lp=new LoginPage(driver);
				lp.loginToApplication(USERNAME, PASSWORD);
			
			
			//step 6:click on Create Organization look Up Image 
			OrganizationsPage op=new OrganizationsPage(driver);
			op.clickOnCreateOrgLookUpImg();
			
			//step 7:Create organization 
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createOrganization(ORGNAME,INDUSTRY);
										
			//step 8: Validate
			String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (OrgHeader.contains(ORGNAME))
			{
				System.out.println("pass");
				System.out.println(OrgHeader);
			}
			else
			{
				System.out.println("fail");
			}
			
																		
			//Step 9:LogOut
			HomePage hp=new HomePage(driver);
			hp.logOutOfApp(driver);
			System.out.println("Logout successfull");
			
		
	}

	


}

