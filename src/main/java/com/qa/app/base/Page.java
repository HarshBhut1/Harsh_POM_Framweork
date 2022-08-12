package com.qa.app.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.app.utils.Constants;

public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,Duration.ofSeconds(Constants.DEFAULT_ELEMENT_WAIT_TIME_OUT));;
	}

	// abstract Methods
	// EveryPage must have this abstracts methods:

	public abstract String getPageTittle();
	
	public abstract WebElement getElement(By locator);

	public abstract String getPageHeader(By locator);


	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
