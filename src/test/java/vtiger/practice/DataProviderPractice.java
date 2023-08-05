package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class DataProviderPractice {

	@Test(dataProvider="getdata")
	public void addToCarttest(String name,int price,String model)
	{
		System.out.println(" Phone name is "+name+" price is "+price+" model is "+model);
	}
	
	@DataProvider(name="getdata")
	public Object[][]getData()
	{
		Object[][] data=new Object[3][3];
		
		data[0][0]="Iphone";//1St set of Data
		data[0][1]=20000;
		data[0][2]="S13";
		
		data[1][0]="Samsung";//2nd set of Data
		data[1][1]=15000;
		data[1][2]="A80";
		
		data[2][0]="Vivo";//3rd set of Data
		data[2][1]=10000;
		data[2][2]="Y21";
		
		return data;
		
	}
	
	
}
