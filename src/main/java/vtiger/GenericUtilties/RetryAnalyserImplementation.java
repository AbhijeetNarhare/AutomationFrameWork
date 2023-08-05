package vtiger.GenericUtilties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyser interface
 * @author abhijeet
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=1;
	int retryCount=3;
	                               //pass //fail
	public boolean retry(ITestResult result) {
		    //1<=3 2<=3 3<=3 4<=3
		while(count<=retryCount)
		{
			count++; //2 3 4
			return true; // retry retry retry
		}
		
	
		return false; //dont retry
	}

}
