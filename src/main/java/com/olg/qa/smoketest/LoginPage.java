package com.olg.qa.smoketest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.olg.qa.baseclass.TestBase;

public class LoginPage extends TestBase{
	
	//page factory or OR
	@FindBy(xpath="//*[@id=\"Olgtopnavigationloginregisterlink\"]")
	WebElement lgRgButton;
	@FindBy(name= "username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="eligible")
	WebElement eligible;
	@FindBy(name="responsible")
	WebElement responsible;
	@FindBy(xpath="//input[@id='loginSubmitbtn']")
	WebElement lgButton;
	@FindBy(xpath="//img[contains(@alt, 'PlayOLG.ca')]")
	WebElement olglogo;		
	@FindBy(xpath="//*[@id=\"olglogin1_form\"]/div[2]/div/div/div[1]/div/a")
	WebElement RgBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateOLGImage() {
		return olglogo.isDisplayed();
	}
	
	//public void lgrgButton() {
	//	lgRgButton.click();
	//}
	
	public InitialRgLimits login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		eligible.click();
		//eligible.isSelected();
		responsible.click();
		//responsible.isSelected();
		lgButton.click();
		return new InitialRgLimits();
		
	}
	//click on the register button
		public RegisterPlayer clickRegister() {
			RgBtn.click();	
			return new RegisterPlayer();
		}

}
