package vtiger.GenericUtilties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consists of all the basic configuration annotations for 
 * all the common actions
 * @author Abhijeet
 *
 */
public class BaseClass {
	

	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver = null;
	
	//Only used for listener to take screenshot
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("====== db connection successful ======");
	}
	
	//@Parameters("browser") //hold a value
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		//Read browser name and URL from property File
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		
		
		String URL = pUtil.getDataFromPropertyFile("url");
			
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " === Browser launched ===");

		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " === Browser launched ===");
		} else {
			System.out.println("==== invalid Browser name ====");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//Only used for listener to take screenshot
		sdriver=driver;

		//Load the URL
		driver.get(URL);
		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		//read username and passowrd from property file
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		System.out.println("==== Login Successful ====");
	}


	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logOutOfApp(driver);
		
		System.out.println("==== Logout Successful ====");
	}
		
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println(" ========== Browser Closed ========");
	}
		
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("====== db connection closed ======");
	}

}