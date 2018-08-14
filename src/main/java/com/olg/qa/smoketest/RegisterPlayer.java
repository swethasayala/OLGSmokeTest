package com.olg.qa.smoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.olg.qa.baseclass.TestBase;

public class RegisterPlayer extends TestBase{
	
	
	@FindBy(name="firstName")
	WebElement Fname;
	@FindBy(name="lastName")
	WebElement Lname;
	@FindBy(name="dob")
	WebElement Dob;
	@FindBy(name="street")
	WebElement Address;
	 //scroll
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="phonenumber")
	WebElement phnumber;
	@FindBy(name="email")
	WebElement emailid;
	@FindBy(name="confirmEmail")
	WebElement confirmemailid;
	@FindBy(xpath="//*[@id=\"regstep1submit\"]")
	WebElement nextBtnReg1;
	@FindBy(xpath="//*[@id=\"pageHero\"]/div/h1[1]")
	WebElement RegLogo;
	@FindBy(name="username")
	WebElement Usernm;
	@FindBy(name="password")
	WebElement userpwd;
	@FindBy(name="password2")
	WebElement confpwd;
	@FindBy(name="playernickname")
	WebElement nicknm;
	@FindBy(name="securityanswer")
	WebElement sanswer1;
	@FindBy(name="securityanswer2")
	WebElement sanswer2;
	@FindBy(xpath="//*[@id=\"registrationFormStep2\"]/fieldset/div[15]/button[1]")
	WebElement nextBtnReg2;
	@FindBy(xpath="//*[@for=\"i_acknowledge1\"]")
	WebElement checkbox1;
	@FindBy(xpath="//*[@for=\"i_acknowledge2\"]")
	WebElement checkbox2;
	@FindBy(xpath="//*[@for=\"i_acknowledge3\"]")
	WebElement checkbox3;
	//*[@id="modelRegistrationTandCsanchor"]/span
	@FindBy(xpath="//*[@id=\"modelRegistrationTandCsanchor\"]/span")
	WebElement tandclink;
	//*[@id="registrationFormStep2"]/fieldset/div[15]/button[1]
	@FindBy(xpath="//*[@for=\"mobiletcs\"]")
	WebElement tandcbox;
	@FindBy(id="agree_btn")
	WebElement agreeBtn;
	@FindBy(id="buttonsubmitstep3")
	WebElement submitBtn;
	
	
	public RegisterPlayer() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateRegTitle() {
		return driver.getTitle();
	}
	
	public boolean validateRegLogo() {
		return RegLogo.isDisplayed();
	}
	
	
	public void RegisterNewPlayer(String ftname, String ltname, String DateOB,String addr, 
			String phone,String em, String confirmem, String offpromo,String username, String password, String confirmpassword,
			String nickname,String SQ1, String SA1, String SQ2, String SA2, String casinoapp	) throws InterruptedException {
		
		Fname.sendKeys(ftname);
		Lname.sendKeys(ltname);
		Dob.sendKeys(String.valueOf(DateOB));
		Address.sendKeys(addr);
		Thread.sleep(4000);
		Address.sendKeys(Keys.ARROW_DOWN);
		Address.sendKeys(Keys.ENTER);
		phnumber.sendKeys(String.valueOf(phone));
		emailid.sendKeys(em);
		confirmemailid.sendKeys(confirmem);
		Select promooffers = new Select(driver.findElement(By.name("i_promo")));
		promooffers.selectByVisibleText(offpromo);
		nextBtnReg1.isEnabled();
		Thread.sleep(3000);
		nextBtnReg1.click();
		nextBtnReg1.click();
		Thread.sleep(3000);
		Usernm.sendKeys(username);
		userpwd.sendKeys(password);
		confpwd.sendKeys(confirmpassword);
		nicknm.sendKeys(nickname);
		Thread.sleep(3000);
		Select squestion1 = new Select(driver.findElement(By.name("securityquestion1")));
		squestion1.selectByVisibleText(SQ1);
		sanswer1.sendKeys(SA1);
		Select squestion2 = new Select(driver.findElement(By.name("securityquestion2")));
		squestion2.selectByVisibleText(SQ2);
		sanswer2.sendKeys(SA2);
		Thread.sleep(3000);
		Select casapp = new Select(driver.findElement(By.name("i_mobileaccess")));
		casapp.selectByVisibleText(casinoapp);
		nextBtnReg2.isEnabled();
		nextBtnReg2.click();
		nextBtnReg2.click();
		Thread.sleep(3000);
		checkbox1.click();
		checkbox2.click();
		checkbox3.click();	
		tandclink.click();
		Thread.sleep(3000);
		agreeBtn.isEnabled();
		tandcbox.click();
		agreeBtn.click();
		Thread.sleep(2000);
		submitBtn.click();
	}

}
