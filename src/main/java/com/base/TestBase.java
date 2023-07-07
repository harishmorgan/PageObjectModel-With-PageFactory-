package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public TestBase() throws IOException {
		
		// First we need to create an object for properties class
		
				 properties = new Properties();
				
				//we need to specify the properties file location
				
				FileInputStream fi= new FileInputStream("C:\\Users\\bhara\\eclipse-workspace\\POMWithPageFactory\\src\\main\\java\\com\\config\\config.properties");
				
				//To load the properties File
				
				properties.load(fi);
		
	}
	
	public static void initialization() {
		
		//to read data from Properties file
		
		String applnUrl=properties.getProperty("baseUrl");
		
		String browserName = properties.getProperty("browser");
				
				if(browserName.equals("chrome")) {
					
					//To Initialize the browser with application
					
					WebDriverManager.chromedriver().setup();

					driver = new ChromeDriver();

				}else if(browserName.equals("FireFox")) {
					
					WebDriverManager.firefoxdriver().setup();

					driver = new FirefoxDriver();
	}
				driver.get(applnUrl);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
				driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_Timeout, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtils.ImplicitlyWait, TimeUnit.SECONDS);
				
	}

}
