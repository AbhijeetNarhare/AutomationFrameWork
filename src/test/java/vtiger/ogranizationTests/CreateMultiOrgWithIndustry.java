package vtiger.ogranizationTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilties.BaseClass;

import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;

import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultiOrgWithIndustry extends BaseClass{
	

	   
   
   @Test(dataProvider = "getData")
   public void createMultiOrg(String ORG,String INDUSTRY) throws Throwable
   {
	   
	   
	  
	   
	   /* Read data from property File - Common Data */    
	
		
		/*Read data from excel sheet*/
		 String ORGNAME = ORG+jUtil.getrandomNumber();
	 
	   
	// Step 2: Launch the browser - driver is acting based runtime data - RunTime
			// polymorphism
			

			
			// Step 3: Load the URL
			

			// Step 4: Login to the Application
			
			// Step 5: Click on Organizations Link
			HomePage hp = new HomePage(driver);
			hp.ClickOnOrgLink();

			// Step 6: click on Create Organization look up image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgLookUpImg();

			// Step 7: create Organization
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createOrganization(ORGNAME, INDUSTRY);
			
			//Step 8:Save
			driver.findElement(By.name("button")).click();

			// Step 9: Validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String OrgHeader = oip.getHeader();
			
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			System.out.println(OrgHeader);
		
			
   }
	
   @DataProvider
   public Object[][] getData() throws Throwable
   {
	   return eUtil.readMultipleData("MultiOrg");
   }
	
}