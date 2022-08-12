package com.qa.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.app.base.TestBase;
import com.qa.app.pages.LandingPage;
import com.qa.app.pages.LoginPage;
import com.qa.app.utils.Constants;

public class LandingPageTest extends TestBase{
	
	@BeforeClass
	public void landingPageSetUp() {
		
		landingPage = page.getInstance(LandingPage.class);
		
	}
	
	@Test(priority = 1, description = "Varifying Landing Page Tittle")
	public void landingPageTittleTest() {
		String tittle = landingPage.getPageTittle();
		String expected = Constants.LANDING_PAGE_TITTLE;
		Assert.assertEquals(tittle, expected);
		
	}
	
	@Test(priority = 2, description = "Verifying the Header on Landing Page")
	public void verifyHeader() {
		
		String header = landingPage.getHeader();
		String expected = Constants.LANDING_PAGE_HEADER;
		Assert.assertEquals(header, expected);
	}
	
	@Test(priority = 3, description = "Verifying if Login Button is clickable or not")
	public void verifyLoginButton() {
		Assert.assertTrue(landingPage.verifyLoginButton());
	}
	
	@Test(priority = 4, description = "Verifying is Join Button is clickable or not")
	public void verifyJoinbutton() {
		Assert.assertTrue(landingPage.getJoinButton());
	}
	
	@Test(priority = 5, description = "Clicking on Login Button and verifying that user is on Login Page")
	public void getLogin() {
		
		LoginPage loginPage = landingPage.getLogin();
		String header = loginPage.getHeader();
		String expected = Constants.LOG_IN_PAGE_HEADER;
		Assert.assertEquals(header, expected);
		
	}
	
}
