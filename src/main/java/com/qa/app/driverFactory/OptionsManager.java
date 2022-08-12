package com.qa.app.driverFactory;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	public static Logger log = LogManager.getLogger(OptionsManager.class.getName());
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless")))
			// co.setHeadless(true);
			co.addArguments("--headless=chrome");
			log.info("Running Chrome Browser in HEADLESS mode");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			co.addArguments("--incognito");
			log.info("Running Chrome Browser in INCOGNITO mode");
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless")))
			fo.setHeadless(true);
		log.info("Running FireFox Browser in HEADLESS mode");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			fo.addArguments("--incognito");
		log.info("Running FireFox Browser in INCOGNITO mode");
		return fo;
	}

	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();

		if (Boolean.parseBoolean(prop.getProperty("headless")))
			eo.setHeadless(true);
		log.info("Running Edge Browser in HEADLESS mode");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			eo.addArguments("--incognito");
		log.info("Running Edge Browser in INCOGNITO mode");
		return eo;
	}
}
