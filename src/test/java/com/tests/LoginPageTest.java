package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.TestUtils;

public class LoginPageTest extends TestBase{
	
	TestUtils testUtils;
	LoginPage loginPage;
	HomePage homePage;
	
	//constructor
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod	
	public void setUp() throws IOException {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
    public void loginTitleTest() throws IOException {  
          
		// Verify login page text
          String loginPageTitle = loginPage.validateLoginPageTitle();
          Assert.assertEquals(loginPageTitle, "Swag Labs","Test Passed");
    }
	
	@Test(priority = 2)
    public void loginTest() throws IOException {
		 homePage = loginPage.login(properties.getProperty("UserName"), properties.getProperty("password"));
    }
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
