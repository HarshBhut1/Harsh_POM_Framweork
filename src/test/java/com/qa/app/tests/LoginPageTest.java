package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.TestBase;
import com.qa.app.pages.LandingPage;
import com.qa.app.utils.Constants;

public class LoginPageTest extends TestBase{
	
	@BeforeClass
	public void loginPageSetUp() {
		
		
		loginPage = page.getInstance(LandingPage.class).getLogin();
	}
	
	@Test(priority = 1, description = "Verifying the Header on Login Page")
	public void verifyLoginPageHeader() {
		String header = loginPage.getHeader();
		String expected = Constants.LOG_IN_PAGE_HEADER;
		Assert.assertEquals(header, expected);
	}
	
	@Test(priority = 2, description = "Verifying if Remember Me link is working or not on Login Page")
	public void verifyRememberMeLink() {
		Assert.assertTrue(loginPage.getRememberMe());
	}
	
	@Test(priority = 3, description = "Verifying if Sign Up link is working or not on Login Page")
	public void verifySignUp() {
		Assert.assertTrue(loginPage.getSignUp());
	}
	
	@Test(priority = 4, description = "Verifying if Forgot Password is working or not on Login Page")
	public void verifyForgotPassword() {
		Assert.assertTrue(loginPage.getForgotPassword());
	}
	
	@Test(priority = 5, description = "Doing Login and verifying if user is Logged in or not and is on Home Page")
	public void doLogin() {
		homePage =loginPage.doLogin("harshbhut123@gmail.com", "Harsh@12111995");
		String name = homePage.getName();
		String expected = Constants.USER_LOGGED_IN_WITH_USERNAME;
		Assert.assertEquals(name, expected);
	}

}
