package org.atmecs.website.pages;

import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.helper.ValidaterHelper;
import org.openqa.selenium.WebDriver;


public class FooterValidater {
	ActionHelper helper=new ActionHelper();
	ValidaterHelper validate=new ValidaterHelper(); 
	public void validateFooter(WebDriver driver,String[] footerarray,Properties prop,String hometitle,String abouttitle,String servicestitle,String partnerstitle,String careertitle,String contacttitle) {
		driver.manage().window().maximize();
		validate.validateTitle(driver, hometitle);
		helper.scrollPage(driver);
		validate.validateElements(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.about"), driver);
		validate.validateTitle(driver,abouttitle);
		helper.scrollPage(driver);
		validate.validateElements(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.mouseOver(prop.getProperty("loc.menu.services"), driver);
		helper.clickElement(prop.getProperty("loc.menu.services"), driver);
		validate.validateTitle(driver,servicestitle);
		helper.scrollPage(driver);
		validate.validateElements(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.partners"), driver);
		validate.validateTitle(driver,partnerstitle );
		helper.scrollPage(driver);
		validate.validateElements(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.careers"), driver);
		validate.validateTitle(driver, careertitle );
		helper.scrollPage(driver);
		validate.validateElements(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
		helper.clickElement(prop.getProperty("loc.menu.contactus"), driver);
		validate.validateTitle(driver,abouttitle);
		helper.scrollPage(driver);
		validate.validateElements(driver, prop.getProperty("loc.footer.container.xpath"), footerarray);
	}
}
