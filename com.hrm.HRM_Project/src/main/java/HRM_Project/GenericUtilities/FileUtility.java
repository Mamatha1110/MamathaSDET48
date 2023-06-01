package HRM_Project.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to handle Property files
 * @author Admin
 *
 */
public class FileUtility {

	/**
	 * This method is used to get value from property file
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.propertyFilePath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}
}
