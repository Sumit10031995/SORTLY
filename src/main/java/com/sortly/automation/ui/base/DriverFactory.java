package com.sortly.automation.ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
	protected static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public WebDriver driver;

	public WebDriver initialiseDriver(String browser) {
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
		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}
}
