package org.atmecs.website.testscripts;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import org.atmecs.website.constants.FileConstants;
import org.atmecs.website.pages.InsightsPage;
import org.atmecs.website.testbase.TestBase;
import org.atmecs.website.utils.ExcelReader;
import org.atmecs.website.utils.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Insights  extends TestBase   {
	InsightsPage insight=new InsightsPage();
	ExcelReader excelread=new ExcelReader();
	PropertiesReader property=new PropertiesReader();
	@DataProvider(name = "insightsdata")
	public String[][] getInsightsData() throws IOException {
		String Excelarray[][] = null;
		Excelarray = excelread.excelDataProviderArray(FileConstants.INSIGHTS_TEST_DATE_PATH);
		return Excelarray;
	}
	@Test(priority=1,dataProvider="insightsdata")
	public void validateBlogs(String title1,String content,String breadcrumb) throws IOException, InterruptedException, ParseException {
	Properties propObject=property.KeyValueLoader(FileConstants.INSIGHT_PATH);
	logger=extentObject.startTest("Validate Blogs and Comments");
	insight.validateBlogs(driver, propObject,title1,content,breadcrumb);
	}
}
