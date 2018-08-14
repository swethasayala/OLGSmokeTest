package com.olg.qa.smoketesttests;

import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.olg.qa.baseclass.TestBase;
import com.olg.qa.smoketest.Homepage;
import com.olg.qa.smoketest.LoginPage;
import com.olg.qa.smoketest.RegisterPlayer;
import com.olg.qa.util.TestUtil;

public class RegisterplayerTest extends TestBase{
	
	Homepage hpage;
	LoginPage loginpage;
	RegisterPlayer RgPlayer;
	String sheetName = "Register";
	
	public RegisterplayerTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		hpage = new Homepage();
		loginpage = new LoginPage();
	    RgPlayer = new RegisterPlayer(); 
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		hpage.lgrgButton();
		//loginpage.lgrgButton();
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "PlayOLG Online Casino and Lottery | Login and Register");
		loginpage.clickRegister();
	}
	
	@DataProvider
	public Object[][] getRegisterdata(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=2, dataProvider="getRegisterdata")
	public void RegisterNewPlayerTest(String firstname, String lastname, String DOB,String address, 
			String phoneno,String email, String confirmemail, String offerpromo,String username, String password, 
			String confirmpassword,String nickname,	String SQ1, String SA1, String SQ2, String SA2, String casinoapp) throws InterruptedException {
		
		hpage.lgrgButton();
		loginpage.clickRegister();
		RgPlayer.RegisterNewPlayer(firstname, lastname, DOB, address, phoneno, email,confirmemail,offerpromo, username,
				password, confirmpassword, nickname, SQ1, SA1,SQ2,SA2, casinoapp);
		
	}
		
		//@AfterMethod
		//public void end() {
		//	driver.quit();
			
		//}

	
	
	
	
}
