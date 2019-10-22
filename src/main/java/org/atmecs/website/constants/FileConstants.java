package org.atmecs.website.constants;
/* file constants are created for the user can run any system the program should run 
 * and the file location is access is make easier using this class */
public class FileConstants {
	//creating file constants for the config properties file paths
	public static final String CONFIG_PATH = "./config.properties";
	
	//creating file constants for the browser .exe file paths
	public static final String CHROME_DRIVER_PATH ="./libs/chromedriver.exe";
	public static final String FIREFOX_DRIVER_PATH ="./libs/geckodriver.exe";
	public static final String IE_DRIVER_PATH="./libs/IEDriverServer.exe";
	public static final String EDGE_DRIVER_PATH="./libs/msedgedriver.exe";
	
	//creating file constants for the log4j file path
	public static final String LOG4J_CONFIG_PROPERTY_PATH ="./src/test/resources/log4j/log4j.properties";
	
	//creating file constants for the extend report file paths
	public static final String EXTENT_OUPUT_PATH="./src/test/resources/extent/extent.html";
	public static final String SCREENSHOT_PATH=System.getProperty("user.dir")+"/src/test/resources/extent/screenshot/";
	public static final String EXTENT_CONFIG_PATH ="./src/test/resources/extent/extent-config.xml";
	
	
	public static final String LOCATOR_PATH="./src/test/resources/locators/locator.properties";
	public static final String INSIGHT_PATH="./src/test/resources/locators/insight.properties";
	public static final String SERVICES_PATH="./src/test/resources/locators/services.properties";
	//testdata
	public static final String FOOTER_TEST_DATA_PATH="./src/test/resources/testdata/footertestdata.xlsx";
	public static final String SERVICES_TEST_DATE_PATH="./src/test/resources/testdata/servicestestdata.xlsx";
	public static final String INSIGHTS_TEST_DATE_PATH="./src/test/resources/testdata/insights.xlsx";
	}
