package vtiger.practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
	@Test(priority = 2,invocationCount = 3)
	public void createCustomer()
	{
		System.out.println("customer crated");
	}
	
	@Test(invocationCount = 2)
	public void modifyCustomer()
	{
		System.out.println("customer modified");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("customer deleted");
	}

}
