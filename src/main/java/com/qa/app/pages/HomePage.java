package com.qa.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.app.base.BasePage;

public class HomePage extends BasePage{
	
	By name = By.xpath("//span[@class='navbar-current-user']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getName() {
		return getElement(name).getText();
	}
	
	

}
