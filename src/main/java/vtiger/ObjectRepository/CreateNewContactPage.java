package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilties.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {

	//declaration
		@FindBy(name = "lastname")
		private WebElement LastNameEdt;
		
		@FindBy(name = "button")
		private WebElement SaveBtn;
		
		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
		private WebElement OrgLookUpImg;
		
		@FindBy(name = "search_text")
		private WebElement OrgSearchEdt;
		

		@FindBy(name = "search")
		private WebElement OrgSearchBtn;
		
		//initilization
	    public CreateNewContactPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }

	    
		public WebElement getLastNameEdt() {
			return LastNameEdt;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}

		public WebElement getOrgLookUpImg() {
			return OrgLookUpImg;
		}

		public WebElement getOrgSearchEdt() {
			return OrgSearchEdt;
		}

		public WebElement getSearchBtn() {
			return OrgSearchBtn;
		}
		
		 //Business library
	    

		/**
	     * This method will create contact with mandatory information
	     */
	    public void createContact(String LASTNAME)
	    {
	    	LastNameEdt.sendKeys(LASTNAME);
	    }

		public void createContact(WebDriver driver, String LASTNAME,  String ORGNAME)
		{
			LastNameEdt.sendKeys(LASTNAME);
			OrgLookUpImg.click();
			switchToWindow(driver, "Accounts");
			OrgSearchEdt.sendKeys(ORGNAME);
			OrgSearchBtn.click();
			driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
			switchToWindow(driver, "Contacts");
			SaveBtn.click();
			
		}
		
}
