package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement CreateContactLookUpImg; 
	
	//initilization
    public ContactsPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    
    public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	
    //Business library
    

	/**
     * This method will click on create contact lookup image
     */
    public void clickOnCreateContactLookUpImg()
    {
    	CreateContactLookUpImg.click();
    }


	

}
