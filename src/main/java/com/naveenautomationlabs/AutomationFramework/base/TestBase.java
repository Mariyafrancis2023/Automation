package com.naveenautomationlabs.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.naveenautomationlabs.AutomationFramework.Listeners.WebdriverEvents;
import com.naveenautomationlabs.AutomationFramework.Utils.Browsers;
import com.naveenautomationlabs.AutomationFramework.Utils.Environments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver wd;
	public static WebDriverWait wait;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebdriverEvents events;
	private EventFiringWebDriver eDriver;
	private Browsers BROWSER = Browsers.CHROME;
	private Environments ENV = Environments.PROD;
	
	public TestBase() {
		prop = new Properties();
		
		try {
			fileInputStream = new FileInputStream("C:\\Users\\me\\eclipse-workspace\\AutomationFramework\\src\\main\\java\\com\\naveenautomationlabs\\AutomationFramework\\config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}
	
	public void initialization() {		
		switch (BROWSER.getNameOfBrowser()) {
//		String browserName = System.getProperty("browser");
//		switch (browserName) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
			wd = WebDriverManager.firefoxdriver().create();
			break;
			default:
				System.out.println("Not a valid browser name");
				break;
		}
		
		eDriver = new EventFiringWebDriver(wd);
		events = new WebdriverEvents();
		eDriver.register(events);
		wd = eDriver;
		
		wd.get(ENV.getUrl());
		
		wait = new WebDriverWait(wd, Long.parseLong(prop.getProperty("EXPLICIT_WAIT")));
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
		wd.manage().window().maximize();
	}
	
	public void tearDown() {
		wd.quit();
	}
}
