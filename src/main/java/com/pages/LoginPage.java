package com.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory

	@FindBy(name = "user-name")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "login-button")
	WebElement login;

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Get the title of Login Page
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public HomePage login(String strUserName, String strPasword) throws IOException {

		// Fill user name
		userName.sendKeys(strUserName);

		// Fill password
		password.sendKeys(strPasword);

		// Click Login button
		login.click();
		return new HomePage();

	}

}
