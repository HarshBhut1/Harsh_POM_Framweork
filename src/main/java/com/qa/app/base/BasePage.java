package com.qa.app.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTittle() {

		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {

		WebElement element;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some error has occured while locating this WebElement : " + locator.toString());
			element = null;
		}
		return element;
	}

	@Override
	public String getPageHeader(By locator) {

		return getElement(locator).getText();
	}
	
	public boolean waitForElementToBeClickable(By locator) {
		
		if(wait.until(ExpectedConditions.elementToBeClickable(locator)) != null) {
			return true;
		}
		return false;
		
	}

}
