package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	@Test(retryAnalyzer=vtiger.GenericUtilties.RetryAnalyserImplementation.class)
	public void sample(){
		Assert.fail();
		System.out.println("Hi");
		
	}

}
