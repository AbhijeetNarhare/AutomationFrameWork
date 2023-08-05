package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct {

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProLookUpImg;
	
	public CreateNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProLookUpImg() {
		return createProLookUpImg;
	}
	
	public void clickOnCreateProductLookUpImg()
	{
		createProLookUpImg.click();
	}
	
	
}
