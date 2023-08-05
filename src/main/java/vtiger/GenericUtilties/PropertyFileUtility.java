package vtiger.GenericUtilties;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consist of generic method related to property file
 * @author abhijeet
 *
 */
public class PropertyFileUtility {

	/**
	 * This method reads Data from Property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Iconstants.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		 String value = p.getProperty(key);
		 return value;
		 
		 
	}
}
