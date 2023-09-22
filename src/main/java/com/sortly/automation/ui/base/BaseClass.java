package com.sortly.automation.ui.base;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sortly.automation.fileutils.PropertiesReader;
import com.sortly.automation.reportconfig.ExtentReportManager;
import com.sortly.automation.reportconfig.Setup;

@Listeners(Setup.class)
public class BaseClass extends ExtentReportManager {
	private final Logger logger = Logger.getLogger(BaseClass.class.getName());
	protected static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	protected void lunchBrowser(@Optional("firefox") String browser) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		if (browser.toLowerCase().contains("chrome")) {
			ChromeOptions co = new ChromeOptions();
			tlDriver.set(new ChromeDriver(co));
		} else if (browser.toLowerCase().contains("firefox")) {
			tlDriver.set(new FirefoxDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(PropertiesReader.getPropertyDetails("sortly.app.baseurl"));
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	@AfterMethod(alwaysRun = true)
	protected void quitQuit() {
		getDriver().quit();
		logger.info("Browser closed successfully");

	}

	public <T> T initializeElements(Class<T> pageObjectClass) {
		T page = PageFactory.initElements(getDriver(), pageObjectClass);
		return page;
	}

}
