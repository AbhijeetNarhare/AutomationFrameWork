package vtiger.contactsTest;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilties.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;

import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


public class CreateContactWithOrganisationTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void createContactWithOrgTest() throws Throwable {

		/* Create Organization */

		// Step 1: Read all the necessary data

		String ORGNAME = eUtil.getDataFromExcelFile("Contacts", 4, 3) + jUtil.getrandomNumber();
		String LASTNAME = eUtil.getDataFromExcelFile("Contacts", 4, 2);

		// Step 5: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();

		// Step 6: click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 6: create Organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		
		//Step 7:Save
		driver.findElement(By.name("button")).click();

		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader=oip.getHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);

		/* Create Contact using Organization */

		// step 9: click on contacts link - 500 - update 
		hp.clickOnContactsLink();

		// Step 10: Navigate to create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// step 10: Create a contact with mandatory information
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);
		
		

		// Step 12: Save Validate for Organization
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader=cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
	    System.out.println(ContactHeader);
	    
	    
	    
	}
		
	@Test (groups="RegressionSuite")  
	public void demotest()
	{
		System.out.println("demo");
	}
	
	

	

	
	}


