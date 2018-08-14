package com.olg.qa.smoketesttests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.olg.qa.baseclass.TestBase;
import com.olg.qa.smoketest.Homepage;
import com.olg.qa.smoketest.InitialRgLimits;
import com.olg.qa.smoketest.LoginPage;

public class SpinButtontest extends TestBase {
	

	LoginPage loginpage;
	InitialRgLimits InitialRG;
	Homepage hpage;
	
	
	public SpinButtontest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginpage = new LoginPage();
		hpage.lgrgButton();
		InitialRG = loginpage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		
	}
	
		
	@Test(priority=1)
	public void loginTest() {
		hpage.lgrgButton();
		InitialRG = loginpage.login(Prop.getProperty("username"), Prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void end() {
		//driver.quit();
		boolean flag = loginpage.validateOLGImage();
		Assert.assertTrue(flag);
	}

}
