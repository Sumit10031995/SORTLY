package com.sortly.automation.ui.page;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.sortly.automation.assertionhandler.Assertions;
import com.sortly.automation.ui.base.BaseClass;
import com.sortly.automation.ui.elements.SortlyItemsPageElements;
import com.sortly.automation.ui.elements.SortlyUITags;
import com.sortly.automation.ui.utils.KeyboardActions;
import com.sortly.automation.ui.utils.SeleniumActionsUtil;
import com.sortly.automation.ui.utils.WaitUtils;
import com.sortly.automation.xpathUtils.XpathsUtils;

public class SortlyItemsPage extends BaseClass {
	private WaitUtils wait = new WaitUtils();

	@FindBy(xpath = "//button[contains(@class,'ui__ButtonRoot')]")
	private WebElement addNewButton;
	@FindBy(xpath = "//span[text()='Add Folder']")
	private WebElement addFolderButton;
	@FindBy(xpath = "//input[@placeholder='Name*']")
	private WebElement nameTextbox;
	@FindBy(xpath = "(//div[contains(@Class,'Input__InputBoundary-sc-dtb')])[1]")
	private WebElement nameText;
	@FindBy(xpath = "//input[@aria-labelledby='tags']")
	private WebElement tags;
	@FindBy(xpath = "//span[text()='Notes']/following::textarea[1]")
	private WebElement description;
	@FindBy(xpath = "//div[@data-testid='add-photos']//span[contains(text(), '(Max 8 photos, 30 MB Total)')")
	private WebElement maxPhotoLimit;
	@FindBy(xpath = "//span[text()='Show All Fields")
	private WebElement showAllFields;
	@FindBy(xpath = "//span[text()='Add to Folder'")
	private WebElement addToFolder;
	@FindBy(xpath = "//span[text()='All Items'")
	private WebElement defaultSelectedFolder;
	@FindBy(xpath = "//button[@data-testid=\"submit-button\" and @type=\"submit\"]")
	private WebElement addButton;
	@FindBy(id = "tags-dropdown")
	private WebElement tagsDropdown;
	@FindBy(xpath = "//button[contains(@class, 'ui__WideActionButtonCmp') and .//span[contains(@class, 'ui__MoreActionsIcon')]]")
	private WebElement threeDots;
	@FindBy(xpath = "//span[@class='sc-beySbM kvwUNw'][contains(text(),'Show:')]")
	private WebElement folderCreatedMessage;
	@FindBy(xpath = "//div[@data-testid='delete']")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@data-testid='Edit']")
	private WebElement editButton;
	@FindBy(xpath = "//div[@data-testid='clone']")
	private WebElement cloneButton;
	@FindBy(xpath = "//div[@data-testid='move']")
	private WebElement moveToFolder;
	@FindBy(xpath = "//button[@data-testid='submit-button' and contains(text(), 'Delete')]")
	private WebElement deleteConformation;
	@FindBy(xpath = "//input[@value='Test']")
	private WebElement folderSearchBox;
	@FindBy(xpath = "//button[@data-testid='submit-button']")
	private WebElement moveButton;

	public WaitUtils getWait() {
		return wait;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public WebElement getAddFolderButton() {
		return addFolderButton;
	}

	public WebElement getNameTextbox() {
		return nameTextbox;
	}

	public WebElement getNameText() {
		return nameText;
	}

	public WebElement getTags() {
		return tags;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getMaxPhotoLimit() {
		return maxPhotoLimit;
	}

	public WebElement getShowAllFields() {
		return showAllFields;
	}

	public WebElement getAddToFolder() {
		return addToFolder;
	}

	public WebElement getDefaultSelectedFolder() {
		return defaultSelectedFolder;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getTagsDropdown() {
		return tagsDropdown;
	}

	public WebElement getThreeDots() {
		return threeDots;
	}

	public WebElement getFolderCreatedMessage() {
		return folderCreatedMessage;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getCloneButton() {
		return cloneButton;
	}

	public WebElement getMoveToFolder() {
		return moveToFolder;
	}

	public WebElement getDeleteConformation() {
		return deleteConformation;
	}

	public WebElement getFolderSearchBox() {
		return folderSearchBox;
	}

	public WebElement getSumbitButton() {
		return moveButton;
	}

	public boolean clickAddNewButton(SortlyItemsPage page) {
		boolean isEqual = Assertions.assertEquals("Text " + SortlyItemsPageElements.addNew + " Not Matching",
				SortlyItemsPageElements.addNew, wait.elementToBeClickable(page.getAddNewButton()).getText());
		page.getAddNewButton().click();
		return isEqual;

	}

	public boolean clickOnAddFolderButton(SortlyItemsPage page) {
		boolean isEqual = Assertions.assertEquals("Text " + SortlyItemsPageElements.addFolder + " Not Matching",
				SortlyItemsPageElements.addFolder, wait.elementToBeClickable(page.getAddFolderButton()).getText());
		page.getAddFolderButton().click();
		return isEqual;
	}

	public boolean sendKeysToNameTextBox(SortlyItemsPage page, String keys) {
		page.getNameTextbox().sendKeys(keys);
		return page.getNameTextbox().isEnabled();
	}

	public boolean sendKeysToTagsTextBox(SortlyItemsPage page, String keys) {
		page.getTags().sendKeys(keys);
		SeleniumActionsUtil action = new SeleniumActionsUtil(getDriver());
		action.clickENTER(page.getTags());
		action.clickESC(page.getTags());
		return page.getTags().isEnabled();
	}

	public boolean sendKeysToNotesTextBox(SortlyItemsPage page, String keys) {
		page.getDescription().sendKeys(keys);
		return page.getDescription().isEnabled();
	}

	public boolean uploadImages(SortlyItemsPage page, String keys) {
		page.getDescription().sendKeys(keys);
		SeleniumActionsUtil action = new SeleniumActionsUtil(getDriver());
		action.clickESC(page.getDescription());
		return page.getDescription().isEnabled();
	}

	public boolean clickOnAddButton(SortlyItemsPage page) {
		boolean isTrue = page.getAddButton().isEnabled();
		page.getAddButton().click();
		return isTrue;
	}

	public boolean isFolderCreated(SortlyItemsPage page, String key) {
		boolean isEqual = Assertions.assertEquals("Text " + key + " Not Matching", key,
				wait.visibilityOf(getDriver()
						.findElement(XpathsUtils.generateXPathEqualsForVisibleText(SortlyUITags.spanTag, key)))
						.getText());
		return isEqual && getDriver()
				.findElement(XpathsUtils.generateXPathEqualsForVisibleText(SortlyUITags.spanTag, key)).isDisplayed();

	}

	public boolean clickOnNewFolder(SortlyItemsPage page, String key) {
		String xpath = "//span[@data-testid='name']/descendant::span[text()='" + key + "']";
		getDriver().navigate().refresh();
		boolean isAddNewFolderVisible = wait.visibilityOf(getDriver().findElement(By.xpath(xpath))).isDisplayed();
		wait.visibilityOf(getDriver().findElement(By.xpath(xpath))).click();
		return isAddNewFolderVisible;

	}

	public boolean deleteFolder(SortlyItemsPage page, String key) {
		String xpath = "//span[@data-testid='name']/descendant::span[text()='" + key + "']";
		getDriver().navigate().refresh();
		wait.visibilityOf(getDriver().findElement(By.xpath(xpath))).click();
		boolean isThreeDotsVisible = wait.elementToBeClickable(page.getThreeDots()).isDisplayed();
		wait.elementToBeClickable(page.getThreeDots()).click();
		boolean isDeleteButtonEnabled = wait.visibilityOf(page.getDeleteButton()).isEnabled();
		wait.visibilityOf(page.getDeleteButton()).click();
		boolean isDeleteConfirmButtonEnabled = wait.visibilityOf(page.getDeleteConformation()).isEnabled();
		wait.visibilityOf(page.getDeleteConformation()).click();
		boolean isFolderVisible = false;
		try {
			Thread.sleep(4000);
			WebElement element = getDriver().findElement(By.xpath(xpath));
		} catch (NoSuchElementException | InterruptedException e) {
			isFolderVisible = true;
		}
		return isThreeDotsVisible && isDeleteButtonEnabled && isDeleteConfirmButtonEnabled && isFolderVisible;

	}

	public boolean moveToFolder(SortlyItemsPage page, String toFolder, String movedFolder) throws InterruptedException {
		boolean isThreeDotsVisible = wait.elementToBeClickable(page.getThreeDots()).isDisplayed();
		wait.elementToBeClickable(page.getThreeDots()).click();
		boolean isMoveToFolderButtonEnabled = wait.visibilityOf(page.getMoveToFolder()).isEnabled();
		wait.visibilityOf(page.getMoveToFolder()).click();
		wait.elementToBeClickable(getDriver()
				.findElement(XpathsUtils.generateXPathContainsForVisibleText(SortlyUITags.spanTag, toFolder))).click();
		wait.elementToBeClickable(page.getSumbitButton()).click();
		Thread.sleep(4000);
		String xpath = "//span[@data-testid='name']/descendant::span[text()='" + movedFolder + "']";
		wait.elementToBeClickable(getDriver().findElement(XpathsUtils.generateXPathContainsForVisibleText(SortlyUITags.spanTag, toFolder))).click();
		getDriver().navigate().refresh();

		boolean isMovedFolderExist = wait.visibilityOf(getDriver().findElement(By.xpath(xpath))).isDisplayed();
		return isThreeDotsVisible && isMoveToFolderButtonEnabled && isMovedFolderExist;

	}

	public boolean cloneFolder(SortlyItemsPage page, String key) {
		boolean isThreeDotsVisible = wait.elementToBeClickable(page.getThreeDots()).isDisplayed();
		wait.elementToBeClickable(page.getThreeDots()).click();
		boolean isMoveToFolderButtonEnabled = wait.visibilityOf(page.getCloneButton()).isEnabled();
		wait.visibilityOf(page.getCloneButton()).click();
		wait.elementToBeClickable(page.getSumbitButton()).click();
		String xpath = "//span[@data-testid='name']/descendant::span[text()='" + key + " (Copy)']";
		getDriver().navigate().refresh();
		boolean isMovedFolderExist = wait.visibilityOf(getDriver().findElement(By.xpath(xpath))).isDisplayed();
		return isThreeDotsVisible && isMoveToFolderButtonEnabled && isMovedFolderExist;

	}

}
