package com.olg.qa.smoketesttests;

//import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.olg.qa.baseclass.TestBase;
import com.olg.qa.smoketest.Homepage;
import com.olg.qa.smoketest.InitialRgLimits;
import com.olg.qa.smoketest.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	InitialRgLimits InitialRG;
	Homepage hpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		hpage = new Homepage();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		hpage.lgrgButton();
		//loginpage.lgrgButton();
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "PlayOLG Online Casino and Lottery | Login and Register");
		
	}
	
	@Test(priority=2)
	public void loginpageLogoTest() {
		boolean flag = loginpage.validateOLGImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
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
