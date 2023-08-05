package vtiger.practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;





public class Vtiger {

	public static void main(String[] args) {
		
		Random r = new Random();
		int random = r.nextInt();
		
	    //step 1: Launching the browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2:Load the url
		driver.get("http://localhost:8888/");
		
		//step 3:Login to application
		 driver.findElement(By.cssSelector("[name=\"user_name\"]")).sendKeys("admin");
		 driver.findElement(By.cssSelector("[name=\"user_password\"]")).sendKeys("admin");
		 driver.findElement(By.cssSelector("[id=\"submitButton\"]")).click();
		 
//Scenario 1:---------->Click on Contact link-------------------------------------------------------
		 
		//step 4:click on Contacts link
		 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		 
		//step 5:click on Create contact look Up Image
		 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 
		//step6:Create Contact
		 driver.findElement(By.cssSelector("[name=\"lastname\"]")).sendKeys("Dinga");

		//step 7:Save
		     driver.findElement(By.name("button")).click();
		     
		//step 8:Validate
		      WebElement ContHeader = driver.findElement(By.xpath("//span[contains(text(),' Dinga ')]"));
		      String headerText = ContHeader.getText();
		      if( headerText.contains("Dinga"))
		     {
		    	 System.out.println("pass");
		    	 System.out.println( headerText);
		     }
		     else 
		     {
		    	 System.out.println("fail");
		     }
		 
		 
//Scenario 2:---------->Click on organization link-----------------------------------------------------------
		 
		//step 4:click on Organization link
		 driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		 
		//step 5:click on Create Organization look Up Image 
	     driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	     
	    //step6:Create organization
	     String OrgName = "KungFu "+random;
	     driver.findElement(By.cssSelector("[name=\"accountname\"]")).sendKeys(OrgName);
	     driver.findElement(By.cssSelector("[name=\"website\"]")).sendKeys("www.kungfu.com");
	  
	   //step 7:Save
	     driver.findElement(By.name("button")).click();
	     
	   //step 8:Validate
	      WebElement OrgHeader = driver.findElement(By.xpath("//span[contains(text(),' KungFu ')]"));
	      String headerText1 = OrgHeader.getText();
	      if( headerText1.contains("KungFu"))
	     {
	    	 System.out.println("pass");
	    	 System.out.println(headerText1);
	     }
	     else 
	     {
	    	 System.out.println("fail");
	     }
	      
//Scenario 3:---------->Click on organization link---select chemicals in the industry dropdown-------------------------------------------------
			 
			/*//step 4:click on Organization link
			 driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			 
			//step 5:click on Create Organization look Up Image 
		     driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		     
		    //step6:Create organization
		     String OrgName1 = "KungFu"+random;
		     driver.findElement(By.cssSelector("[name=\"accountname\"]")).sendKeys(OrgName1);
		     driver.findElement(By.cssSelector("[name=\"website\"]")).sendKeys("www.kungfu.com");
		     
		   //step 7:choose 'chemicals' in drop down
		     WebElement industryDropDown = driver.findElement(By.name("industry"));
		     Select s = new Select(industryDropDown);
		     s.selectByValue("Chemicals");
		  
		   //step 8:Save
		     driver.findElement(By.name("button")).click();
		     
		   //step 9:Validate
		      WebElement OrgHeader1 = driver.findElement(By.xpath("//span[contains(text(),' KungFu ')]"));
		      String headerText2 = OrgHeader1.getText();
		      if( headerText2.contains("KungFu"))
		     {
		    	 System.out.println("pass");
		    	 System.out.println(headerText2);
		     }
		     else 
		     {
		    	 System.out.println("fail");
		     }
		 
//Scenario 4:---------->Click on organization link---select Energy in the industry Dropdown & customer in type dropdown------------------------------------------------
		 
			//step 4:click on Organization link
			 driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			 
			//step 5:click on Create Organization look Up Image 
		     driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		     
		    //step 6:Create organization
		     String OrgName2 = "KungFu"+random;
		     driver.findElement(By.cssSelector("[name=\"accountname\"]")).sendKeys(OrgName2);
		     driver.findElement(By.cssSelector("[name=\"website\"]")).sendKeys("www.kungfu.com");
		     
		   //step 7:choose 'Energy' in drop down
	          WebElement IndustryDropDOwn1 = driver.findElement(By.name("industry"));
	          Select I1 = new Select(IndustryDropDOwn1);
	          I1.selectByValue("Energy");
	          
	        //step 8:choose 'Energy' in drop down
	          WebElement TypeDropDown = driver.findElement(By.name("accounttype"));
	          Select T1 = new Select(TypeDropDown);
	          T1.selectByValue("Customer");
	          
		  
		   //step 9:Save
		     driver.findElement(By.name("button")).click();
		     
		   //step 10:Validate
		      WebElement OrgHeader2 = driver.findElement(By.xpath("//span[contains(text(),' KungFu ')]"));
		      String headerText3 = OrgHeader2.getText();
		      if( headerText3.contains("KungFu "))
		     {
		    	 System.out.println("pass");
		    	 System.out.println(headerText3);
		     }
		     else 
		     {
		    	 System.out.println("fail");
		     }
		
//Scenario 5:---------->Create contact & select the organization------------------------------------------------
				 
		    //step 4:click on Contacts link
				 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				 
			//step 5:click on Create contact look Up Image
				 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				 
			//step6:Create Contact
				 driver.findElement(By.cssSelector("[name=\"lastname\"]")).sendKeys("Dinga");

			//step 7:Save
				     driver.findElement(By.name("button")).click();
				     
				     
				     
				     
		    //step 8:Validate
		      WebElement ContHeader1 = driver.findElement(By.xpath("//span[contains(text(),' Dinga ')]"));
			  String headerText4 = ContHeader1.getText();
				      if( headerText4.contains("Dinga"))
				     {
				    	 System.out.println("pass");
				    	 System.out.println( headerText4);
				     }
				     else 
				     {
				    	 System.out.println("fail");
				     }
				      
		  //step 9:click on organization module	& select organization module	      
				 driver.findElement(By.xpath("//a[.='Organizations']")).click();
				 driver.findElement(By.id("5")).click();
		      */
		      
//step 11:Logout-------------------------------------------------------------------------------------------------
	  WebElement AdminTag = driver.findElement(By.xpath("(//img[@border='0'])[3]"));
	     Actions act = new Actions(driver);
	     act.moveToElement(AdminTag).perform();
	     
	     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	     
	     System.out.println("LogOut Successfull");
	}

}
