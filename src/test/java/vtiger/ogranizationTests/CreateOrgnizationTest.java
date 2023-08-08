package vtiger.ogranizationTests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilties.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilties.ListenerImplimentationClass.class)
public class CreateOrgnizationTest extends BaseClass{
   
	@Test (groups = "SmokeSuite")
	public void CreateOrgTest() throws Throwable  {
		
		
	/*	Scenario 3: Orgaganization name, industryType-Energy, Type-Customer
		Launch Browser
		Login to application with valid credentials
		Navigate to Organizations link
		Click on Create Organization look Up Image
		Create Organization with Mandatory fields
		Select "Energy" in the industry drop down
		Select "Customer" in the Type Drop down 
		Save and Verify
		logout of Application*/
		
		//Create object of required Utilities
		        
						
			
						
				// Step 1: Read all the necessary data
						
			
						
				/*Read data from excel sheet */
				String ORGNAME = eUtil.getDataFromExcelFile("Organizations", 10, 2)+jUtil.getrandomNumber();
				String INDUSTRY = eUtil.getDataFromExcelFile("Organizations", 10, 3);
				
				
						
				//Step 2: Launch the Browser- driver is acting based runtime data - RunTime polymorphism
		
				

				// Step 5: Click on Organizations Link
				
					
					 //step 5:click on Organization link		
					//driver.findElement(By.linkText("Organizations")).click();
				 HomePage hp=new HomePage(driver);
				 hp.clickOnOrgLink();
					Reporter.log("Org link clicked");
					
					//step 6:click on Create Organization look Up Image 
					//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
					OrganizationsPage op=new OrganizationsPage(driver);
					op.clickOnCreateOrgLookUpImg();
					Reporter.log("CreateOrg LookUp Img is clicked");
					
					//step 7:Create organization with mandatory information
					//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);	
					CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
					cnop.createOrganization(ORGNAME);
					Reporter.log("Organization Created");
										
					
					//step 8:choose 'Energy' in Industry drop down
					WebElement industryDropDown = driver.findElement(By.name("industry"));
					wUtil.handleDropDown(industryDropDown, INDUSTRY);
					Reporter.log("Organization Created with Industry");
					
					
					//Step 10:Save
					driver.findElement(By.name("button")).click();
					//step 11: Validate
					OrganizationInfoPage oip = new OrganizationInfoPage(driver);
					String OrgHeader=oip.getHeader();
					Assert.assertTrue(OrgHeader.contains(ORGNAME));
									
					System.out.println(OrgHeader);	
					
					System.out.println("hi");
													
					
				
					
	}
	@Test
	public void demotest()
	{
		//Assert.fail();
		System.out.println("demo");
	}
	
	

}
