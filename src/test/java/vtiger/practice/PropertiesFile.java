package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//step 1: load the document in java readable format
		 FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\data.properties");
		//step 2: create object of properties class from java.util
		 Properties pro = new Properties();
		//step 3: load the file into properties file
		pro.load(fis);
		//step 4: provide the key and get the value
		String value = pro.getProperty("username");
       System.out.println("username ="+value );
		
		//step 1 :Load the file in java readable format
		FileInputStream fis1 = new FileInputStream(".\\src\\main\\resources\\data.properties");
		//step 2 :create object of properties class from java .util
		Properties pro1 = new Properties();
		//step 3: load the file into properties file
		pro1.load(fis1);
		//step 4:provide the key and get the value
		String value1 = pro1.getProperty("password");
		System.out.println("password ="+value1);
		
		//step 1 :load the document in java readable format
		FileInputStream fis2 = new FileInputStream(".\\\\src\\\\main\\\\resources\\\\data.properties");
		//step 2:create object of properties class from java.util
		Properties pro2 = new Properties();
		//step 3 :load the file into properties file
		pro2.load(fis2);
		//step 4:provide the key and get the value
		String value2 = pro2.getProperty("url");
		System.out.println("url ="+value2);
		
		
		//step 1: load the document in java readable format
		FileInputStream fis3 = new FileInputStream(".\\\\src\\\\main\\\\resources\\\\data.properties");
		//step 2: creat object of properties class from java.util
		Properties pro3 = new Properties();
		//step 3:load the file into properties file
		pro3.load(fis3);
		//step 4:provide the key and get the value
		String value3 = pro3.getProperty("browser");
		System.out.println(value3);
		
		
	}

}
