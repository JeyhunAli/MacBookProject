package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(String browserName) {
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//tldriver.set(new ChromeDriver());
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			//tldriver.set(new FirefoxDriver());
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("safari")) {
			
		}
		else {
			System.out.println( browserName+"Browser Value is Wrong please pass the correct browser Name...");
			
		}
		
	
		driver.manage().deleteAllCookies();
		driver.get("https://app.hubspot.com/login");
		
		return driver;
			
	}
	
	/**
	 * this method is used to read all the properties from properties file 
	 * @return ---->> prop
	 */
	public Properties init_properties() {
		
		 prop = new Properties();
		try {
			FileInputStream input = new FileInputStream("/Users/jey/eclipse-workspace/MacBookProject/src/main/java/com/Config/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			System.out.println("config file is missing please check it then correct it....");
			} catch (IOException e) {
				System.out.println("properties file couldn't be loaded ");
			e.printStackTrace();
		}
		return prop;
		//this return statement says give me the browser i will give you driver 
		
	}
	
	
	
	
	
	

	}
