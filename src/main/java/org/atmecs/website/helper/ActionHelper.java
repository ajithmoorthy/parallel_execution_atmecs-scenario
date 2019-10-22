package org.atmecs.website.helper;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.atmecs.website.extentreports.Extent;
import org.atmecs.website.logreports.LogReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * Class is created for the implement the reusablity
 * it is contains many method when ever we want we can access*/
public class ActionHelper extends Extent {
	LogReporter log=new LogReporter();
	By xpath,id,name,className,linkText,cssSelector,partialLink,tag;
	/**
	 * This method will perform the separate the locators and options and send to the action method.
	 * @param locators
	 * @param webdriver
	 */
	public void clickElement(String locators, WebDriver webdriver) {
		String[] input=locators.split(",");
		switch(input[0]){
		case "XPATH":
			xpath=By.xpath(input[1]);
			actionMethod(webdriver,xpath);
			break;
		case "ID":
			id=By.id(input[1]);
			actionMethod(webdriver,id);
			break;
		case "NAME":
			name=By.name(input[1]);
			actionMethod(webdriver,name);
			break;
		case "CSS_SELECTOR":
			cssSelector=By.cssSelector(input[1]);
			actionMethod(webdriver,cssSelector);
			break;
		case "CLASS":
			className=By.className(input[1]);
			actionMethod(webdriver,className);
			break;
		case "LINK_TEXT":
			linkText=By.linkText(input[1]);
			actionMethod(webdriver,linkText);
			break;
		case "PARTIAL_LINK_TEXT":
			partialLink=By.partialLinkText(input[1]);
			actionMethod(webdriver,partialLink);
			break;	
		case "TAG_NAME":
			tag=By.tagName(input[1]);
			actionMethod(webdriver,tag);
			break;
		default:
			System.out.println("Locator type doesn't exist ");
			break;
		}
	}
	/**
	 * action method perform the click operation.
	 * @param webdriver
	 * @param locator
	 */
	public void actionMethod(WebDriver webdriver,By locator) {
		try {
			WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
			wait2.until(ExpectedConditions.elementToBeClickable(locator));
			WebElement click_operation = webdriver.findElement(locator);
			click_operation.click();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * This method  separate the locators and options and send to the SendKeysMethod.
	 * @param locators
	 * @param webdriver
	 */
	public void sendKeys(String locators, WebDriver webdriver,String value) {
		String[] input=locators.split(",");
		switch(input[0]){
		case "XPATH":
			xpath=By.xpath(input[1]);
			sendKeysMethod(xpath,webdriver,value);
			break;
		case "ID":
			id=By.id(input[1]);
			sendKeysMethod(id,webdriver,value);
			break;
		case "NAME":
			name=By.name(input[1]);
			sendKeysMethod(name,webdriver,value);
			break;
		case "CSS_SELECTOR":
			cssSelector=By.cssSelector(input[1]);
			sendKeysMethod(cssSelector,webdriver,value);
			break;
		case "CLASS":
			className=By.className(input[1]);
			sendKeysMethod(className,webdriver,value);
			break;
		case "LINK_TEXT":
			linkText=By.linkText(input[1]);
			sendKeysMethod(linkText,webdriver,value);
			break;
		case "PARTIAL_LINK_TEXT":
			partialLink=By.partialLinkText(input[1]);
			sendKeysMethod(partialLink,webdriver,value);
			break;	
		case "TAG_NAME":
			tag=By.tagName(input[1]);
			sendKeysMethod(tag,webdriver,value);
			break;
		default:
			System.out.println("Locator type doesn't exist ");
			break;
		}
	}
	/**
	 * This method send the String to the Web Elements.
	 * @param locator
	 * @param webdriver
	 * @param value
	 */
	public void sendKeysMethod(By locator, WebDriver webdriver,String value) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement sendtext = webdriver.findElement(locator);
		sendtext.sendKeys(value);
	}
	/**
	 * This method will perform the separate the locators and options and send to the mouseOver method.
	 * @param locators
	 * @param webdriver
	 */
	public void mouseOver(String locators, WebDriver webdriver) {
		String[] input=locators.split(",");
		switch(input[0]){
		case "XPATH":
			xpath=By.xpath(input[1]);
			mouseOverMethod(xpath,webdriver);
			break;
		case "ID":
			id=By.id(input[1]);
			mouseOverMethod(id,webdriver);
			break;
		case "NAME":
			name=By.name(input[1]);
			mouseOverMethod(name,webdriver);
			break;
		case "CSS_SELECTOR":
			cssSelector=By.cssSelector(input[1]);
			mouseOverMethod(cssSelector,webdriver);
			break;
		case "CLASS":
			className=By.className(input[1]);
			mouseOverMethod(className,webdriver);
			break;
		case "LINK_TEXT":
			linkText=By.linkText(input[1]);
			mouseOverMethod(linkText,webdriver);
			break;
		case "PARTIAL_LINK_TEXT":
			partialLink=By.partialLinkText(input[1]);
			mouseOverMethod(partialLink,webdriver);
			break;	
		case "TAG_NAME":
			tag=By.tagName(input[1]);
			mouseOverMethod(tag,webdriver);
			break;
		default:
			System.out.println("Locator type doesn't exist ");
			break;
		}
	}
	/**
	 * this method is perform the mouseOver operation
	 * @param locator
	 * @param webdriver
	 */
	public void mouseOverMethod(By locator,WebDriver webdriver) {
		Actions actions = new Actions(webdriver);
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element=webdriver.findElement(locator);
		actions.moveToElement(element).perform();
	}
	/**
	 * 
	 * @param locators
	 * @param webdriver
	 */
	public void dropDown(String locators, WebDriver webdriver,int value) {
		String[] input=locators.split(",");
		switch(input[0]){
		case "XPATH":
			xpath=By.xpath(input[1]);
			dropDownMethod(xpath,webdriver,value);
			break;
		case "ID":
			id=By.id(input[1]);
			dropDownMethod(id,webdriver,value);
			break;
		case "NAME":
			name=By.name(input[1]);
			dropDownMethod(name,webdriver,value);
			break;
		case "CSS_SELECTOR":
			cssSelector=By.cssSelector(input[1]);
			dropDownMethod(cssSelector,webdriver,value);
			break;
		case "CLASS":
			className=By.className(input[1]);
			dropDownMethod(className,webdriver,value);
			break;
		case "LINK_TEXT":
			linkText=By.linkText(input[1]);
			dropDownMethod(linkText,webdriver,value);
			break;
		case "PARTIAL_LINK_TEXT":
			partialLink=By.partialLinkText(input[1]);
			dropDownMethod(partialLink,webdriver,value);
			break;	
		case "TAG_NAME":
			tag=By.tagName(input[1]);
			dropDownMethod(tag,webdriver,value);
			break;
		default:
			System.out.println("Locator type doesn't exist ");
			break;
		}
	}
	/**
	 * this method used for the automate the drop down web Elements. 
	 * @param locators
	 * @param webdriver
	 * @param index
	 * @return
	 */
	public void dropDownMethod(By locators, WebDriver webdriver, int index) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(locators));
		WebElement dropdown = webdriver.findElement(locators);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}
	
	//this the method for handle the windows in web driver
	public WebDriver winHandler(WebDriver driver) {
		String window_array[]=new String[5];
		Set<String> windows=driver.getWindowHandles();
		int initial=0;
		for (String win:windows)
		{
			window_array[initial]=win;
		}
		driver=driver.switchTo().window(window_array[0]);
		return driver;
	}
	/**
	 * this method will perform the login for each web page.
	 * @param webdriver
	 * @param loc_username
	 * @param loc_password
	 * @param submit
	 * @param input_Username
	 * @param input_Password
	 */
	public void loginMethod(WebDriver webdriver,String loc_username,String loc_password,String submit,String input_Username,String input_Password) {
		sendKeys(loc_username,webdriver, input_Username);
		sendKeys(loc_password,webdriver, input_Password);
		clickElement(submit, webdriver);	
	}
	
	
	//this method is used to perform the mouse over with drop down selection
	public void menuMouseOver(WebDriver webdriver,String locator,String option) {
		Actions actions = new Actions(webdriver);
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		WebElement element=webdriver.findElement(By.xpath(locator));
		actions.moveToElement(element).perform();
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(option)));
		WebElement optionElement=webdriver.findElement(By.xpath(option));
		optionElement.click();
	}
	public void mouseOverClick(WebDriver webdriver,String locator,String option) {
		Actions actions = new Actions(webdriver);
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		WebElement element=webdriver.findElement(By.cssSelector(locator));
		actions.moveToElement(element).perform();
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(option)));
		WebElement optionElement=webdriver.findElement(By.cssSelector(option));
		optionElement.click();
	}
	//this method is used to select the option from the send Keys what we send
	public void sendKeysDropDown(WebDriver webdriver,String locator,String optionRoot,String value) {
		sendKeys(locator,webdriver,value);
		Actions action=new Actions(webdriver);
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list = webdriver.findElements(By.xpath(optionRoot));
		for(WebElement  element:list) {
			System.out.println(element.getText());
			if(element.getText().equalsIgnoreCase(value)) {
				action.moveToElement(element).perform();
				element.click();
			}

		}
	}
/**
 * scrollPage method will scroll the web page using java script
 * @param driver
 */
	public void scrollPage(WebDriver driver,int variable) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+variable+")");
	}
	public void scrollPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)");
	}
	public void menuMouseOverClick(WebDriver webdriver,String locator) {
		Actions actions = new Actions(webdriver);
		WebDriverWait wait2 = new WebDriverWait(webdriver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		WebElement element=webdriver.findElement(By.cssSelector(locator));
		actions.moveToElement(element).perform();
		element.click();
	}


	
}
