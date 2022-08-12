package com.qa.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.app.base.BasePage;

public class LoginPage extends BasePage{
	
	By header = By.className("heading3");
	By emailID = By.id("email");
	By password = By.id("password");
	By forgotPassword = By.linkText("Forgot Password");
	By rememberMe = By.className("v-middle");
	By loginBtn = By.className("btn-primary");
	By signUp = By.linkText("Sign Up");

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Setters
	
	public String getHeader() {
		return getElement(header).getText();
	}

	public WebElement getEmailID() {
		return getElement(emailID);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public boolean getForgotPassword() {
		return waitForElementToBeClickable(forgotPassword);
	}

	public boolean getRememberMe() {
		return waitForElementToBeClickable(rememberMe);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public boolean getSignUp() {
		return waitForElementToBeClickable(signUp);
	}
	
	public HomePage doLogin(String username, String password) {
		getEmailID().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
		
	}
	

}
