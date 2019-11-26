package com.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Base.BasePage;
import com.Utility.Constants;
import com.Utility.ElementUtility;




public class GoogleMainPage extends BasePage {

	
	WebDriver driver;
	ElementUtility elementutil;
	Properties prop;
	
	//1. page object /object repo/ By Locators 
	
	By searchBox = By.xpath("//div[@class='a4bIc']//input[@name='q']");
	By aboutlink = By.xpath("//a[contains(text(),'About')]");
	
	
	//2. creating constructor of page class
	//2. constructor of page class:
		public GoogleMainPage(WebDriver driver){
			this.driver = driver;
			//creating utility object by constructor level and passing driver
			 elementutil = new ElementUtility(driver);
			 elementutil.waitForTitlePresent(Constants.Google_Main_Page, 15);
			prop = new Properties();
		}
		
		//3. page actions / page methods:
		public String getPageTitle(){
			
			String title = elementutil.waitForTitlePresent(Constants.Google_Main_Page, 15);
			System.out.println("Google page title is: "+ title);
			return title;
		}
	
		
		
		
		//this is the page generic method thats why I'm trying to avoid to write the hard coded here just it will read from prop file 
		//later on i will ad this method will return home page 
		public void  passingWordAzerbaijan() {
			
			elementutil.doSendKeys(searchBox, "Azerbaijan");
            
			
		}
		
		
		public  GoogleAzerbaijanHomePage aboutLink () {
			
			elementutil.waitForElementPresent(aboutlink, 10);
			elementutil.isElementDisplayed(aboutlink);
			
			return new GoogleAzerbaijanHomePage(driver);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
