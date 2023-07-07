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

public class HomePageTest extends TestBase{
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	TestUtils testUtils;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod	
	public void setUp() throws IOException {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		homePage = loginPage.login(properties.getProperty("UserName"), properties.getProperty("password"));
	}
	
	
	@Test
    public void HomeTest() throws IOException {
          // Verify home page
		String homePageTitle =homePage.verifyHomePageText();
          Assert.assertTrue(homePageTitle.contains("Products"),"Test Passed");
    }
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

