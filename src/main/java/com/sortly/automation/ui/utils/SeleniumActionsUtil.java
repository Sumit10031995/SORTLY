package com.sortly.automation.ui.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActionsUtil {

	private WebDriver driver;
	private Actions actions;

	public SeleniumActionsUtil(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	public void hoverOverElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	public void doubleClickElement(WebElement element) {
		actions.doubleClick(element).perform();
	}

	public void rightClickElement(WebElement element) {
		actions.contextClick(element).perform();
	}

	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		actions.dragAndDrop(sourceElement, targetElement).perform();
	}

	public void clickESC(WebElement element) {
		try {
			Thread.sleep(2000);
			actions.sendKeys(element, Keys.ESCAPE).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickENTER(WebElement element) {
		try {
			Thread.sleep(2000);
			actions.sendKeys(element, Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void perform() {
		actions.perform();
	}
}
