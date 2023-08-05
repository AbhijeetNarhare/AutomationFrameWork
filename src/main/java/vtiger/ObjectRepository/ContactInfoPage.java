package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ContactInfoPage  {
	
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	//initilization
    public ContactInfoPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

    
    public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}

  //Business library
	/**
     * This method will capture the header text and return it to the caller
     */
    public String getContactHeader()
    {
    	return ContactHeaderText.getText();
    }
}
