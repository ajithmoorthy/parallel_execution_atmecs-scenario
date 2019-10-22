package org.atmecs.website.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import org.atmecs.website.extentreports.Extent;
import org.atmecs.website.logreports.LogReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ValidaterHelper extends Extent{
	LogReporter log=new LogReporter();
	ActionHelper helper=new ActionHelper(); 
	//this method will check the url is correct or not
	public void correctUrlChecker(WebDriver Driver,String Expected_Url){
		try {
			Assert.assertEquals(Driver.getCurrentUrl(),Expected_Url);
			log.logReportMessage("Successfully Validated the correct Url is :"+ Driver.getCurrentUrl());
			logger.log(LogStatus.INFO,"Successfully Validated the correct Url is :" +Driver.getCurrentUrl());
		}catch(AssertionError e) {
			System.out.println("Navigate to wrong Webpage");
			log.logReportMessage("Navigate to wrong Webpage");
			logger.log(LogStatus.INFO, "Navigate to wrong Webpage");
		}	
	}
	//this method validate the page document title
	public void validateTitle(WebDriver driver, String documentTitle){
		try {
			Assert.assertEquals(driver.getTitle(), documentTitle);
			log.logReportMessage("Document title is validated :"+driver.getTitle());
			logger.log(LogStatus.INFO,"Document title is validated :" +driver.getTitle());
		}
		catch(AssertionError e)
		{
			System.out.println("Document title is not match with Expected :"+driver.getTitle());
			log.logReportMessage("Document title is not match with Expected :"+driver.getTitle());
			logger.log(LogStatus.INFO,"Document title is not match with Expected :"+driver.getTitle());	
		}
	}
	//this method will return the inner text of the web elements
	public String webElementgetText(WebDriver webdriver,String locator) {
		WebElement element=webdriver.findElement(By.xpath(locator));
		String content=element.getText();
		return content;
	}
	public void validateElements(WebDriver driver,String locators,String[] footerarray) {
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locators)));
		List<WebElement> list=driver.findElements(By.xpath(locators));
		int count=0;
		while(count<1) {
			for(WebElement element:list)
			{
				String[] elementarray=element.getText().split("\n");
				for(int variable=0; variable<elementarray.length; variable++) {
					assertValidate(elementarray[variable],footerarray[count]);
					count++;
				}
			}
		}
	}
	/**
	 * Aseertvalidate is used to validate the actual and expected values is correct or not. 
	 * @param actual
	 * @param expected
	 */
	public void assertValidate(String actual,String expected) {
		try {
			Assert.assertEquals(actual,expected);
			log.logReportMessage("Actual Value :"+actual+" and Expected :"+expected+" is validated succesfully");
			logger.log(LogStatus.INFO,"Actual Value :"+actual+" and Expected :"+expected+" is validated succesfully");	
		}
		catch(AssertionError e)
		{
			System.out.println("Actual Value :"+actual+" not match wiht the Expected value :"+expected);
			log.logReportMessage("Actual Value :"+actual+" not match wiht the Expected value :"+expected);
			logger.log(LogStatus.INFO,"Actual Value :"+actual+" not match wiht the Expected value :"+expected);
		}

	}
	public void validateBlogContent(WebDriver driver,String locator) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		List<WebElement> list=driver.findElements(By.xpath(locator));
		for(WebElement element:list ) {
			System.out.println(element.getText());
			String[] tempdate=element.getText().split(" ");	
			String exam=tempdate[1].substring(0,tempdate[1].length()-1)+"/"+getMonthNumber(tempdate[0])+"/"+tempdate[2];
			exam=exam.replace("\\s", "");
			String secon=formatter.format(date);
			Date first=formatter.parse(exam);
			Date second=formatter.parse(secon);
			long numdays=daysBetween(first,second);
			if(numdays>90) {
				System.out.println(numdays);
			}
		}
	}
	private static long daysBetween(Date one, Date two) {
		long difference =  (one.getTime()-two.getTime())/86400000;
		return Math.abs(difference);
	}
	private int getMonthNumber(String monthName) {
		return Month.valueOf(monthName.toUpperCase()).getValue();
	}
	public void sample(WebDriver driver,String dateloc,String readloc,String blogtitleloc,String blogcontentloc,String bdateloc,String breadloc,String postloc,String textarealoc,String expectedtitle,String expectedcontent,String expectedbreadcrumb) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(dateloc)));
		List<WebElement> datelist=driver.findElements(By.xpath(dateloc));
		List<WebElement> readlist=driver.findElements(By.xpath(readloc));
		int variable=0,count=0;
		while(count<1){
			while(variable<1) {
				String originaldate=datelist.get(variable).getText();
				String[] tempdate=datelist.get(variable).getText().split(" ");	
				String exam=tempdate[1].substring(0,tempdate[1].length()-1)+"/"+getMonthNumber(tempdate[0])+"/"+tempdate[2];
				exam=exam.replace("\\s", "");
				String secon=formatter.format(date);
				Date first=formatter.parse(exam);
				Date second=formatter.parse(secon);
				long numdays=daysBetween(first,second);
				System.out.println(numdays);
				if(numdays>90) {
					readlist.get(count).click();
					String title=webElementgetText(driver, blogtitleloc);
					String content=webElementgetText(driver, blogcontentloc);
					String breadcrumb=webElementgetText(driver, breadloc);
					String blogdate=webElementgetText(driver, bdateloc);
					assertValidate(breadcrumb, expectedbreadcrumb);
					assertValidate(title, expectedtitle);
					assertValidate(content, expectedcontent);
					assertValidate(blogdate, originaldate);
					helper.scrollPage(driver,4400);
					logger.log(LogStatus.PASS, "Before Toast message");
					helper.clickElement(postloc, driver);
					WebElement inputElement = driver.findElement(By.xpath(textarealoc));
					JavascriptExecutor js = (JavascriptExecutor) driver; 
					boolean isRequired=false;
					isRequired= (Boolean) js.executeScript("return arguments[0].required;",inputElement);
					if(isRequired )
					{
						log.logReportMessage("Toast meaasage is Displayed sucessfully");
						logger.log(LogStatus.PASS,"Toast meaasage is Displayed succesfully");	
					}
					count++;
					variable++;
				}
			}

		}
	}
}

