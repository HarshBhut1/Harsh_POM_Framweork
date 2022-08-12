package com.qa.app.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browser) {
		df = new DriverFactory();
		prop = df.init_Properties();
		if(browser != null) {
			prop.setProperty("browser", browser);
		}
		
		driver = df.init_Driver(prop);
		page = new BasePage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
