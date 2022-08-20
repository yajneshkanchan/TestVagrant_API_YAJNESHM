package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.Icon;

/**
 * it contains External file specific  libraries 
 * @author yajnesh m
 *
 */
public class Propertyfile_Utility {
/**
 * its used to return the value from property file based on key
 * @param key
 * @return value 
 * @throws Throwable
 */
	public String getpropertyKeyAndValue(String key) throws Throwable {
	
		FileInputStream fis = new FileInputStream(IConstant.commonPath);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;

	}
}