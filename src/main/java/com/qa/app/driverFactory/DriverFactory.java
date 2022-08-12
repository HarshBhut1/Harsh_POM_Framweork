package com.qa.app.driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.app.listeners.WebEventListener;
import com.qa.app.utils.Browsers;
import com.qa.app.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	Properties prop;
	FileInputStream ip;
	TakesScreenshot ts;
	WebDriverListener d_Listener;
	EventFiringDecorator event_Driver;
	public static ThreadLocal<WebDriver> tl_Driver = new ThreadLocal<WebDriver>();

	public WebDriver init_Driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		System.out.println(url);

		if (browserName.equalsIgnoreCase(Browsers.chrome.toString())) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			tl_Driver.set(driver);
			
		} else if (browserName.equalsIgnoreCase(Browsers.firefox.toString())) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			tl_Driver.set(driver);
			
		} else if (browserName.equalsIgnoreCase(Browsers.edge.toString())) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			tl_Driver.set(driver);
			
		} else {
			System.out.println("please pass the valid browser name.......");
		}
		
		
		d_Listener = new WebEventListener();
		event_Driver = new EventFiringDecorator(d_Listener);
		driver = event_Driver.decorate(getDriver());
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DEFAULT_TIME_OUT));
		driver.get(url);
		return driver;
	}
	
	public WebDriver getDriver() {

		return tl_Driver.get();
	}


	public Properties init_Properties() {
		ip = null;
		prop = new Properties();

		try {
			ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/configuration/qa.config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) {
		ts = (TakesScreenshot) getDriver();
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir") + "\\screenshot\\" + testCaseName + " - "
				+ System.currentTimeMillis()+ " - " + ".png";
		try {
			FileUtils.copyFile(source, new File(DestinationFile));
		} catch (IOException e) {
			System.out.println("Getting error in creating Screenshot");
			e.printStackTrace();
		}
		
		
		

	
		return DestinationFile;
	}
}
