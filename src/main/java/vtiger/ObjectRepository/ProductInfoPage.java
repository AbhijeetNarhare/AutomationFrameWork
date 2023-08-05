package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	//declaration
		@FindBy(xpath = "//span[@class='lvtHeaderText']")
		private WebElement ProductHeaderText;
		
		//initilization
	    public ProductInfoPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }

	    
	    public WebElement getProductHeaderText() {
			return ProductHeaderText;
		}

	  //Business library
		/**
	     * This method will capture the header text and return it to the caller
	     */
	    public String getProHeaderText()
	    {
	    	return ProductHeaderText.getText();
	    }


		
	}

