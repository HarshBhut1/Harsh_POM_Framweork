package com.qa.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.app.base.BasePage;

public class LandingPage extends BasePage{
	
	//page Locators:
	
	By header = By.linkText("Home");
	
	By login = By.className("register-btn");
	
	By joinButton = By.className("btn-theme");

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public String getTittle() {
		return getPageTittle();
	}
	
	public String getHeader() {
		return getElement(header).getText();
	}

	public boolean verifyLoginButton() {
		
		return waitForElementToBeClickable(login);

	}

	public boolean getJoinButton() {
		
		return waitForElementToBeClickable(joinButton);
	}
	
	public LoginPage getLogin() {
		getElement(login).click();
		return getInstance(LoginPage.class);
	}
	
	

}
