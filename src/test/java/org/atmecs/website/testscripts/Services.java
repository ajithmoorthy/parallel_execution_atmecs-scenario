package org.atmecs.website.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.pages.ServicesPage;
import org.atmecs.website.testbase.TestBase;
import org.atmecs.website.utils.ExcelReader;
import org.atmecs.website.utils.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Services  extends TestBase  {
	ExcelReader excelread=new ExcelReader();
	PropertiesReader property=new PropertiesReader();
	ServicesPage  services=new ServicesPage();
	@DataProvider(name = "servicesdata")
	public String[][] getServiceData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.SERVICES_TEST_DATE_PATH);
		return Excelarray;
	}
	@Test(priority=2,dataProvider="servicesdata")
	public void servicesOptionCheck(String aiorml,String arorvr,String blockchain,String roboticpro,String iot,String infrazstruct,String cloud,String infdevops,String nocservices,String datacenter) throws IOException {
		logger=extentObject.startTest("validate the Services");
		Properties propObject=property.KeyValueLoader(FileConstants.SERVICES_PATH);
		services.servicesOption(driver,propObject,aiorml,arorvr,blockchain,roboticpro,iot,infrazstruct,cloud,infdevops,nocservices,datacenter);
	}
}