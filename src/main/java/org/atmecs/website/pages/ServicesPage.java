package org.atmecs.website.pages;

import java.util.Properties;

import org.atmecs.website.helper.ActionHelper;
import org.atmecs.website.helper.ValidaterHelper;
import org.openqa.selenium.WebDriver;



public class ServicesPage {
	ActionHelper helper=new ActionHelper();
	ValidaterHelper validate=new ValidaterHelper();
	public void servicesOption(WebDriver driver,Properties prop,String aiorml,String arorvr,String blockchain,String roboticpro,String iot,String infrazstruct,String cloud,String infdevops,String nocservices,String datacenter)
	{
		String digitalarray=aiorml+","+arorvr+","+blockchain+","+roboticpro+","+iot;
		String[] testDigital=digitalarray.split(",");
		helper.mouseOver(prop.getProperty("loc.menu.services"),driver);
		helper.mouseOver(prop.getProperty("loc.linktxt.submenudigital"), driver);
		validate.validateElements(driver, prop.getProperty("loc.linktxt.digitaloption"),testDigital);
		helper.mouseOver(prop.getProperty("loc.linktxt.Infrazstructure"), driver);
		String infrazstructarray=infrazstruct+","+ cloud+","+infdevops+","+nocservices+","+datacenter;
		String[] testInfraz=infrazstructarray.split(",");
		validate.validateElements(driver, prop.getProperty("loc.linktxt.infrastructureoption"),testInfraz);
	}
}
