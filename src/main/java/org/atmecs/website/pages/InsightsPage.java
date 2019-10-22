package org.atmecs.website.pages;

import java.text.ParseException;
import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.helper.ValidaterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsightsPage{
	ValidaterHelper validate=new ValidaterHelper();
	boolean bool=false;
	ActionHelper helper=new ActionHelper();
	public void validateBlogs(WebDriver driver,Properties prop,String title,String content,String breadcrumb) throws InterruptedException, ParseException {
		driver.manage().window().maximize();
		helper.mouseOver(prop.getProperty("loc.menu.insights"), driver);
		helper.mouseOver(prop.getProperty("loc.submenu.blogs"), driver);
		helper.clickElement(prop.getProperty("loc.submenu.blogs"), driver);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("loc.readmore.linktext"))));
		validate.sample(driver, prop.getProperty("loc.blogsdate.linktxt.xpath"),prop.getProperty("loc.readmore.linktext"), prop.getProperty("loc.head.blogtitle.xpath"), prop.getProperty("locl.paragraph.blogcontent.xpath"), prop.getProperty("loc.datetime.blog.xpath"),prop.getProperty("loc.breadcrumb.container.xpath"),prop.getProperty("loc.postcomment.btn.xpath"),prop.getProperty("loc.textarea.txtfield.xpath"), title, content,breadcrumb);
	}
}

