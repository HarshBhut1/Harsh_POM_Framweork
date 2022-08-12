package com.qa.app.driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tl_Driver = new ThreadLocal<WebDriver>();
	public static Logger log = LogManager.getLogger(DriverFactory.class.getName());

	public WebDriver init_Driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		System.out.println(url);
		optionsManager = new OptionsManager(prop);
		
		log.info("Running test in Browser - " + browserName);

		if (browserName.equalsIgnoreCase(Browsers.chrome.toString())) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
			tl_Driver.set(driver);
			
		} else if (browserName.equalsIgnoreCase(Browsers.firefox.toString())) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tl_Driver.set(driver);
			
		} else if (browserName.equalsIgnoreCase(Browsers.edge.toString())) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(optionsManager.getEdgeOptions());
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
	
	public static synchronized WebDriver getDriver() {

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
