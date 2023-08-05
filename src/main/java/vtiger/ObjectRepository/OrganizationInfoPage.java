	package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	
	
	//Initilization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}

		
	
	
	//Business Libraries	
	
	/**
	 * This method will capture the Header text and return it to caller
	 * @return 
	 * @return
	 */
	public String getHeader()
	{
		return OrgHeaderText.getText();
	}
	
}
