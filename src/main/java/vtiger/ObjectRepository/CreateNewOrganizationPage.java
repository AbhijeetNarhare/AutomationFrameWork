package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilties.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	   //Declaration
		@FindBy(name = "accountname")
		private WebElement orgNameEdt;
		
		@FindBy(name = "industry")
		private WebElement industryDropDOwn;
		
		@FindBy(name = "accounttype")
		private WebElement typeDropdwn;
		
		@FindBy(name = "button")
		private WebElement saveBtn;
		
		//Initilization
			public  CreateNewOrganizationPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

		//Utilization	
			public WebElement getOrgNameTextB() {
				return orgNameEdt;
			}

			public WebElement getIndustryDropDOwnbtn() {
				return industryDropDOwn;
			}

			public WebElement getTypeDropdwnBtn() {
				return typeDropdwn;
			}

			public WebElement getSaveBtn() {
				return saveBtn;
			}

		//Business Libraries	
		/**
		 * This method will create organization with mandatory fields	
		 * @param ORGNAME
		 */
		public void createOrganization(String ORGNAME)	
		{
			orgNameEdt.sendKeys(ORGNAME);
		}
		
		/**
		 * This method will create organization with Industry Drop Down
		 * @param ORGNAME
		 * @param INDUSTRY
		 */
		public void createOrganization(String ORGNAME,String INDUSTRY)
		{
			orgNameEdt.sendKeys(ORGNAME);
			handleDropDown(industryDropDOwn, INDUSTRY);
		}
}
