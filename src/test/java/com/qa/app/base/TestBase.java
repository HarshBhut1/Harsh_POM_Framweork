package com.qa.app.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.app.driverFactory.DriverFactory;
import com.qa.app.pages.HomePage;
import com.qa.app.pages.LandingPage;
import com.qa.app.pages.LoginPage;

public class TestBase {
	
	
	
	DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	public Page page;
	public LandingPage landingPage;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_Properties();
		driver = df.init_Driver(prop);
		page = new BasePage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
