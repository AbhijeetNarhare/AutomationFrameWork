package Weekend.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExVtiger {

	public static void main(String[] args) {
		
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			driver.get("htts://localhost:8888/");
			
			 driver.findElement(By.cssSelector("[name=\"user_name\"]")).sendKeys("admin");
			 driver.findElement(By.cssSelector("[name=\"user_password\"]")).sendKeys("admin");
			 driver.findElement(By.cssSelector("[id=\"submitButton\"]")).click();
	           
			 test.MaximizeWindow(driver);
		
		
		 
	}

}
