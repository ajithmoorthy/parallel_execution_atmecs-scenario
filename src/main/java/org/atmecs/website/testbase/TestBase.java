package org.atmecs.website.testbase;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.extentreports.Extent;
import org.atmecs.website.logreports.LogReporter;
import org.atmecs.website.utils.PropertiesReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



/*this class will act as the base class for the test it will provide the browser based on the user choice */
public class TestBase extends Extent{
    protected Properties prop=null;
	PropertiesReader propertyReader = new PropertiesReader();
	LogReporter log=new LogReporter();
	/*
	 * this method will provide the browser driver based on the user need by using
	 * the switch case and properties file
	 */
	@SuppressWarnings("deprecation")
	@BeforeTest
	@Parameters("Name")
	public void baseSetup(String browser) throws IOException 
	{
		prop = propertyReader.KeyValueLoader(FileConstants.CONFIG_PATH);
//		String[] chooser=prop.getProperty("webdrivername").split(",");
//		if(chooser[0].equals("GRID")) {
//			String Node = "http://55.55.53.104:4444/wd/hub";
//			switch (chooser[1]) {
//			case "CHROME":
//				System.out.println("Executing on chrome");
//				DesiredCapabilities chrome =new DesiredCapabilities();
//				chrome.setBrowserName("chrome");
//				driver = new RemoteWebDriver(new URL(Node), chrome);
//				break;
//			case "FIREFOX":
//				System.out.println("Executing on FireFox");
//				DesiredCapabilities fire = new DesiredCapabilities();
//				fire.setBrowserName("firefox");
//				driver = new RemoteWebDriver(new URL(Node), fire);
//				break;
//			case "IE":
//				System.out.println("Executing on IE");
//				DesiredCapabilities iecap = new DesiredCapabilities();
//				iecap.setBrowserName("ie");
//				driver = new RemoteWebDriver(new URL(Node), iecap);
//				break;
//			}
//			driver.get(prop.getProperty("url"));
//			log.logReportMessage("url is loaded");
//		}
//		else {
			switch (browser) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", FileConstants.CHROME_DRIVER_PATH);
//				ChromeOptions chromeoptions = new ChromeOptions();
//				chromeoptions.addArguments("--disable-notifications");
//				chromeoptions.addArguments("disable-geolocation");
				driver = new ChromeDriver();
				driver.get(prop.getProperty("url"));
				break;
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", FileConstants.FIREFOX_DRIVER_PATH);
//				FirefoxOptions fire = new FirefoxOptions();
//				fire.addPreference("dom.webnotifications.enabled", false);
				driver = new FirefoxDriver();
				break;
			case "IE":
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				System.setProperty("webdriver.ie.driver", FileConstants.IE_DRIVER_PATH);
				driver=new InternetExplorerDriver(capabilities);
				driver.get(prop.getProperty("url"));
				break;
			case "EDGE":
				System.setProperty("webdriver.edge.driver", FileConstants.EDGE_DRIVER_PATH);
				driver = new EdgeDriver();
				driver.get(prop.getProperty("url"));
				break;
			}
			log.logReportMessage("url is loaded");
		}
	}
