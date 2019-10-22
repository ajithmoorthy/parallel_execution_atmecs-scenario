package org.atmecs.website.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author ajith.periyasamy
 *this class read the properties file using the property method
 */

public class PropertiesReader {
	// property method read the value based on the key value pair
	public  Properties KeyValueLoader(String path) throws IOException {
		File file = new File(path);
		Properties property = new Properties();
		FileInputStream input = new FileInputStream(file);
		property.load(input);
		return property;
	}
}
