package Weekend.practice;



	import java.net.MalformedURLException;
	import java.net.URL;

	import org.openqa.selenium.Platform;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class BrowserStackRun {
		
		RemoteWebDriver driver;
		
		public static final String USERNAME = "abhijitnarhare_O4TQ2q";
		public static final String AUTOMATE_KEY = "yBKtWpP7MBMAYioea82j";
		public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		
		
	@Test(dataProvider ="Data")
	public void browserRun(Platform platform, String BName, String BVersion) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(platform);
		cap.setBrowserName(BName);
		cap.setVersion(BVersion);
		cap.setCapability("name", BName);
		cap.setCapability("browserstack.debug", true);
		
		driver = new RemoteWebDriver(new URL(URL),cap);
		driver.get("http://gmail.com");
		Thread.sleep(2000);
		driver.quit();
		
	}

	@DataProvider(name ="Data", parallel=true)
	public Object[][] getData(){
		Object[][] test = new Object[][] {
			{Platform.WINDOWS,"chrome","111"},
			{Platform.WINDOWS,"firefox","110"},
			{Platform.MAC,"chrome","80"},
			{Platform.LINUX,"chrome","80"}
			};
			return test;
		}

	}


