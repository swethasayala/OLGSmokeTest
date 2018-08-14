package com.olg.qa.baseclass;
import java.util.concurrent.TimeUnit;
import com.olg.qa.util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	
	public static WebDriver driver ;
	public static Properties Prop;
	
	
	public TestBase() {
		try {
			Prop = new Properties();
			FileInputStream ip = new FileInputStream("F:\\seleniumtest\\OLGsmoketest\\src\\main\\java\\com\\olg\\qa\\config\\config.properties");
			Prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void initialize() {
		String Browsername = Prop.getProperty("browser");
		if (Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
						
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(Prop.getProperty("url"));
		
		
		
	}

}
