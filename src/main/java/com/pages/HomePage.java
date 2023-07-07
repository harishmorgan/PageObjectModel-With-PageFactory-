package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase {
	
	
	//PageFactory
	
	@FindBy(xpath = "//span[contains(text(),'Products')]")
	WebElement products;
 

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Get the User name from Home Page
	public String verifyHomePageText(){
		return products.getText();
	}
	
}
