package com.Tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BasePage;
import com.Pages.GoogleMainPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class GoogleMainPageTest {
	
	
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	GoogleMainPage googlePage;

	
	
	@BeforeTest
	public void setUp() {
		
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		
		
//		basePage = new BasePage();                   //creating object
//		prop = basePage.init_properties();           //creating object
//		String browser = prop.getProperty("browser");  //getting property driver by keyname. keyname is in the properties file  
//		driver = basePage.init_driver(browser);        //init driver is in base page by base class name I'm calling and passing driver
//		driver.get(prop.getProperty("url"));           //

	
		googlePage= new GoogleMainPage(driver);         //creating object passing constructor driver
	}
	@Severity(SeverityLevel.NORMAL)
@Description("verify google page title ")
	@Test(priority = 1)
	public void verifyGooglePagTitleTest() {
		Assert.assertEquals(googlePage.getPageTitle(), com.Utility.Constants.Google_Main_Page, "Google  page title is mismatched...");
	}
	
	
	@Test(priority = 2)
	public void passSomeWord () {
		googlePage.passingWordAzerbaijan();
		
	}
	
	@Test(priority = 3)
	public void clicksearchButton() {
		googlePage.aboutLink();
	}

}
