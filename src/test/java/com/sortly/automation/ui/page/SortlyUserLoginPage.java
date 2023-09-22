package com.sortly.automation.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortlyUserLoginPage {
	@FindBy(id = "a")
	private WebElement sortlyLogo;
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//span[text()='Items']")
	private WebElement items;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement search;
	@FindBy(xpath = "//span[text()='Tags']")
	private WebElement tags;
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement reports;
	@FindBy(xpath = "//span[text()='Product News']")
	private WebElement productNews;
	@FindBy(xpath = "//span[text()='Help']")
	private WebElement help;
	@FindBy(xpath = "//span[text()='Notifications']")
	private WebElement notifications;
	@FindBy(xpath = "//span[text()='Settings']")
	private WebElement settings;
	@FindBy(xpath = "//input[@placeholder='Search folders']")
	private WebElement searchFolder;
	@FindBy(xpath = "//span[text()='All Items']")
	private WebElement allItems;
	@FindBy(xpath = "//span[text()='History']")
	private WebElement history;
	@FindBy(xpath = "//span[text()='Trash']")
	private WebElement trash;
	@FindBy(xpath = "//h1[text()='All Items']']")
	private WebElement allItemsLabel;
	@FindBy(xpath = "//input[@placeholder='Search All Items']")
	private WebElement searchAllItems;
	@FindBy(xpath = "//button[text()='Add new']")
	private WebElement addNewButton;
	@FindBy(xpath = "//span[text()='Updated At']")
	private WebElement updatedAt;
	@FindBy(id = "scanner-button-wrapper")
	private WebElement scannerButton;
	@FindBy(xpath = "//span[text()='Folders:']")
	private WebElement foldersText;
	@FindBy(xpath = "//span[text()='Items:']")
	private WebElement itemsText;
	@FindBy(xpath = "//span[text()='Total Quantity:']")
	private WebElement totalQuantityText;
	@FindBy(xpath = "//span[text()='Total Value:']")
	private WebElement totalValueText;
	@FindBy(xpath = "//span[text()='Help']")
	private WebElement helpText;
	@FindBy(xpath = "//span[contains(text(),'Welcome back!')]")
	private WebElement welcomeBackToSortly;
	@FindBy(xpath = "//span[text()='Log in to your account.']")
	private WebElement loginToYourAccount;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//a[@href='/reset-password']")
	private WebElement forgotPassword;
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	@FindBy(xpath = "//span[text()='OR']")
	private WebElement or;
	@FindBy(xpath = "//span[text()='Sign in with Google']")
	private WebElement signInWithGoogle;
	@FindBy(xpath = "//span[text()='Sign in with Apple']")
	private WebElement signInWithApple;
	@FindBy(xpath = "//span[text()='Sign in with SSO']")
	private WebElement signInWithSSO;
	@FindBy(xpath = "//span[text()='New here? ']")
	private WebElement newHere;
	@FindBy(xpath = "//span[text()='Create an account']")
	private WebElement createAccount;

	public WebElement getSortlyLogo() {
		return sortlyLogo;
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getItems() {
		return items;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getTags() {
		return tags;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getProductNews() {
		return productNews;
	}

	public WebElement getHelp() {
		return help;
	}

	public WebElement getNotifications() {
		return notifications;
	}

	public WebElement getSettings() {
		return settings;
	}

	public WebElement getSearchFolder() {
		return searchFolder;
	}

	public WebElement getAllItems() {
		return allItems;
	}

	public WebElement getHistory() {
		return history;
	}

	public WebElement getTrash() {
		return trash;
	}

	public WebElement getAllItemsLabel() {
		return allItemsLabel;
	}

	public WebElement getSearchAllItems() {
		return searchAllItems;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public WebElement getUpdatedAt() {
		return updatedAt;
	}

	public WebElement getScannerButton() {
		return scannerButton;
	}

	public WebElement getFoldersText() {
		return foldersText;
	}

	public WebElement getItemsText() {
		return itemsText;
	}

	public WebElement getTotalQuantityText() {
		return totalQuantityText;
	}

	public WebElement getTotalValueText() {
		return totalValueText;
	}

	public WebElement getHelpText() {
		return helpText;
	}

	public WebElement getWelcomeBackToSortly() {
		return welcomeBackToSortly;
	}

	public WebElement getLoginToYourAccount() {
		return loginToYourAccount;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getOr() {
		return or;
	}

	public WebElement getSignInWithGoogle() {
		return signInWithGoogle;
	}

	public WebElement getSignInWithApple() {
		return signInWithApple;
	}

	public WebElement getSignInWithSSO() {
		return signInWithSSO;
	}

	public WebElement getNewHere() {
		return newHere;
	}

	public WebElement getCreateAccount() {
		return createAccount;
	}

}
