package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import vtiger.GenericUtilties.WebDriverUtility;

public class HomePage extends WebDriverUtility{

       //declaration
		@FindBy(linkText = "Organizations")
		private WebElement  organizationLnk;
		
		@FindBy(linkText = "Contacts")
		private WebElement ContactsLks;
		
		@FindBy(linkText = "Products")
		private WebElement productsLks;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement AdministratorImg;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signOutLnk;
		
		//initialization
		public HomePage (WebDriver driver)
		{
		  PageFactory.initElements(driver, this);
		}


		//Utilization		
		public void ClickOnOrgLink()
		{
			organizationLnk.click();
		}
		
		public WebElement getOrganizationLnk() {
			return organizationLnk;
		}


		public WebElement getContactsLks() {
			return ContactsLks;
		}
		
		
		public WebElement getProductsLks() {
			return productsLks;
		}



		public WebElement getAdministratorImg() {
			return AdministratorImg;
		}


		public WebElement getSignOutLnk() {
			return signOutLnk;
		}


		//Business Library
		/**
		 * This method will click on Organization link
		 */
		public void clickOnOrgLink()
		{
			organizationLnk.click();
		}
		
		/**
		 * This method will click on Contacts link
		 */

		public void clickOnContactsLink()
		{
			ContactsLks.click();
		}
		
	

		/**
		 * This method will click on Products link
		 */
		public void clickOnProductsLink()
		{
			productsLks.click();
		}
		
		/**
		 * This method will logout of application
		 * @param driver
		 * @throws Throwable
		 */
		public void logOutOfApp(WebDriver driver) throws Throwable
		{
			mouseHoverAction(driver,AdministratorImg);
			Thread.sleep(1000);
			signOutLnk.click();
		}

}
