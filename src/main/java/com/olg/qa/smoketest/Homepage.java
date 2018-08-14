package com.olg.qa.smoketest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.olg.qa.baseclass.TestBase;

public class Homepage extends TestBase{

	@FindBy(xpath="//*[@id=\"Olgtopnavigationloginregisterlink\"]")
	WebElement lgRgButton;
	
	public Homepage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public LoginPage lgrgButton() {
		lgRgButton.click();
		return new LoginPage();		
		
	}
	
}
