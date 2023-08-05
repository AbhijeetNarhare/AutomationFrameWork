package vtiger.productTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtilties.BaseClass;
import vtiger.ObjectRepository.CreateNewProduct;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;


public class CreateNewProductWithAVendorTest extends BaseClass{

	@Test
	public void CreateNewProTest() throws Throwable {
		/*Scenario 1
		Navigate to products link
		Click on Create New Product
		Create new Product with A vendor
		Choose 303-interest-income in GL Account Drop down
		Save the product n verify.*/
		
		//Create object of required Utilities
		
		
		// Step 1: Read all the necessary data
		
		/* Read data from property File - Common Data */    
		
		
		/*Read data from excel sheet */
		String VENDOR_NAME = eUtil.getDataFromExcelFile("VENDORS", 1, 2);
		String PRODUCT_NAME = eUtil.getDataFromExcelFile("PRODUCTS", 7, 2);
		String GL_ACCOUNT = eUtil.getDataFromExcelFile("PRODUCTS", 7, 4);
		
		//Step 2: Launch the Browser- driver is acting based runtime data - RunTime polymorphism
		
	
				
		 //step 4:Login to application
		
		
		/*------------------Create new vendor---------------------------------------------------------------*/
		//Step 5:click on product module
		HomePage hp = new HomePage(driver);
		hp.clickOnProductsLink();
		
		//Step 6:click on create Product lookup image
		
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		CreateNewProduct cnp=new CreateNewProduct(driver);
		cnp.clickOnCreateProductLookUpImg();
		
		//Step 7:Create a new product with a vendor
	   driver.findElement(By.name("productname")).sendKeys(PRODUCT_NAME);	   
	
	   WebElement glAccount = driver.findElement(By.name("glacct"));
	   wUtil.handleDropDown(glAccount, GL_ACCOUNT);
	   driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@title='Select']")).click();
		
	//Step 8: Switch to child window
	wUtil.switchToWindow(driver, "Vendors");
	  
	  //Step 9:Search for Vendor name
	  driver.findElement(By.name("search_text")).sendKeys(VENDOR_NAME);
	  driver.findElement(By.name("search")).click();
	  driver.findElement(By.xpath("//a[text()='"+ VENDOR_NAME +"']")).click(); //dynamic xpath
	  
	// Step 10: switch the control back to parent window
	  wUtil.switchToWindow(driver, "Products");  
	  
	  
	  
	 	// Step 8: save
		driver.findElement(By.name("button")).click();
		
		// Step 9:validate
	   ProductInfoPage pip=new ProductInfoPage(driver);
	   String productHeader = pip.getProHeaderText();
	    
	    Assert.assertTrue(productHeader.contains(PRODUCT_NAME));
	    System.out.println(productHeader);
		
		
		
		
		//step 11:Logout-------------------------------------------------------------------------------------------------
		
		 
		/*Create new product with a vendor name*/
		

		
		//Navigate to products link
		//Click on Create New Product
		//Create new Product with A vendor
		//Choose 303-interest-income in GL Account Drop down
		//Save the product n verify.	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
