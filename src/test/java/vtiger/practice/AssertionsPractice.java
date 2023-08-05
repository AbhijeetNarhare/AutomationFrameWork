package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	@Test
	public void sampleTest() 
	{
		SoftAssert sa=new SoftAssert();
		int a=1; //exp
		int b=1; //actual
		
		System.out.println("step 1");
		
		sa.assertEquals(true, true);//true
		
		System.out.println("step 2");
		Assert.assertEquals(b,a);//true
		System.out.println("step 3");
		System.out.println("step 4");
		
		sa.assertTrue(false);//fail
		
		System.out.println("Execution and Validation complete");
		sa.assertAll();//logging all the failures
		
		
	}
}
