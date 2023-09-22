package com.sortly.automation.ui.utils;

import com.sortly.automation.ui.base.BaseClass;
import com.sortly.automation.ui.utils.WaitUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sortly.automation.fileutils.PropertiesReader;

public class WaitUtils extends BaseClass {

	public static int getWaitTimeInSeconds() {
		String waitTime = PropertiesReader.getPropertyDetails("wait.time.seconds");
		return Integer.parseInt(waitTime);
	}

	public WebElement visibilityOf(WebElement wb) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(getWaitTimeInSeconds()));
		return wait.until(ExpectedConditions.visibilityOf(wb));
	}

	public void inVisibilityOf(WebElement wb) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(getWaitTimeInSeconds()));
		wait.until(ExpectedConditions.invisibilityOf(wb));
	}

	public WebElement elementToBeClickable(WebElement wb) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(getWaitTimeInSeconds()));
		return wait.until(ExpectedConditions.elementToBeClickable(wb));

	}

}
