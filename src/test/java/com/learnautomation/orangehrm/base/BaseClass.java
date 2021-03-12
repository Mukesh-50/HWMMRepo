package com.learnautomation.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.orangehrm.dataprovider.ConfigReader;
import com.learnautomation.orangehrm.utility.BrowserFactory;

public class BaseClass 
{
	
	public WebDriver driver;

	public WebDriver getDriver()
	{
		return driver;
	}
	

	@BeforeClass
	public void startBrowser()
	{
		System.out.println("**** Starting Browser ****");
		
		BrowserFactory browser=new BrowserFactory();
		
		ConfigReader config=new ConfigReader();
			
		driver=browser.openBrowser(config.getProperty("Browser"),config.getProperty("stagingURL"));
		
		System.out.println("**** Browser is up and running ****");
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("**** Closing Browser ****");
	}
	
}
