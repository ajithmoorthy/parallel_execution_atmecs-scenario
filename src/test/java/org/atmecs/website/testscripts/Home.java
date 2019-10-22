package org.atmecs.website.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.logreports.LogReporter;
import org.atmecs.website.pages.FooterValidater;
import org.atmecs.website.testbase.TestBase;
import org.atmecs.website.utils.ExcelReader;
import org.atmecs.website.utils.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Home  extends TestBase  {
	PropertiesReader property=new PropertiesReader();
	ExcelReader excelread=new ExcelReader();
	ActionHelper helper=new ActionHelper();
	FooterValidater validate=new FooterValidater();
	LogReporter log=new LogReporter();
	@DataProvider(name = "footerdata")
	public String[][] getFooterData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.FOOTER_TEST_DATA_PATH);
		return Excelarray;
	}
	@Test(priority=0,dataProvider="footerdata")
	public void footerValidate(String sitemapheading,String home,String aboutus,String services,String partners,String casestudies,String news,String careers,String contact,String	servicesheading,String aiormi,String arorvr,String qualityeng,String bockchain,String roboticandchatbots,String cloud,String enterprise,String iot,String mobilecomputing,String product,String careersheading,String automation,String devops,String seniorneteng,String seniorjavaengineer,String contactusheading,String usheadquarters,String randdcenter,String hyderabad,String bangalore,String chennai,String infoatmecs,String ireland,String hometitle,String abouttitle,String servicestitle,String partnerstitle,String careertitle,String contacttitle) throws IOException {
	Properties propObject=property.KeyValueLoader(FileConstants.LOCATOR_PATH);
	logger=extentObject.startTest("validate the Footer");
	String temp=sitemapheading+","+home+","+aboutus+","+services+","+partners+","+casestudies+","+news+","+careers+","+contact+","+servicesheading+","+aiormi+","+arorvr+","+qualityeng+","+bockchain+","+roboticandchatbots+","+cloud+","+enterprise+","+iot+","+mobilecomputing+","+product+","+careersheading+","+automation+","+ devops+","+seniorneteng+","+seniorjavaengineer+","+contactusheading+","+usheadquarters+","+randdcenter+","+hyderabad+","+bangalore+","+chennai+","+infoatmecs+","+ireland;
	String[] footerarray=temp.split(",");
	validate.validateFooter(driver, footerarray, propObject,hometitle,abouttitle,servicestitle,partnerstitle,careertitle,contacttitle);
	}
}
