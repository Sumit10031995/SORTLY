package com.sortly.automation.ui.test;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.sortly.automation.DTO.FolderDTO;
import com.sortly.automation.DTO.UsersDTO;
import com.sortly.automation.assertionhandler.Assertions;
import com.sortly.automation.data.clients.SortlyFolderDataClients;
import com.sortly.automation.dataprovider.SortlyUsersDataProvider;
import com.sortly.automation.ui.base.BaseClass;
import com.sortly.automation.ui.elements.SortlyItemsPageElements;
import com.sortly.automation.ui.elements.SortlyLoginPageElements;
import com.sortly.automation.ui.page.SortlyItemsPage;
import com.sortly.automation.ui.page.SortlyUserLoginPage;
import com.sortly.automation.ui.utils.WaitUtils;
import java.util.Random;

public class SortlyFolderAndItemOperationTests extends SortlyItemsPage {

	@Test(groups = { "createFolder&deleteFolder", "folder",
			"Owner" }, dataProvider = "Owner", dataProviderClass = SortlyUsersDataProvider.class, priority = 0, enabled = true)
	public void addAndDeleteFolderTestByOwner(UsersDTO user) {
		boolean isEqual = true;
		FolderDTO folderDetails = new SortlyFolderDataClients().getFolderTwoDetails();
		SortlyItemsPage page = initializeElements(SortlyItemsPage.class);
		new SortlyUserLoginTests().loginAsAdminWithValidCridentials(user);
		isEqual = isEqual & clickAddNewButton(page);
		isEqual = isEqual & clickOnAddFolderButton(page);
		isEqual = isEqual & sendKeysToNameTextBox(page, folderDetails.getName());
		isEqual = isEqual & sendKeysToTagsTextBox(page, folderDetails.getTagName());
		isEqual = isEqual & sendKeysToNotesTextBox(page, folderDetails.getNotes());
		isEqual = isEqual & clickOnAddButton(page);
		isEqual = isEqual & isFolderCreated(page, folderDetails.getName());
		isEqual = isEqual & deleteFolder(page, folderDetails.getName());
		if (isEqual)
			logPass("Add Folder & Delete Folder Owner Action Successful");
		else
			logFail("Add Folder & Delete Folder Owner Action Failed");

	}

	@Test(groups = { "createFolder&deleteFolder", "folder",
			"Admin" }, dataProvider = "Admin", dataProviderClass = SortlyUsersDataProvider.class, priority = 1, enabled = true)
	public void addAndDeleteFolderTestByAdmin(UsersDTO user) {
		boolean isEqual = true;
		FolderDTO folderDetails = new SortlyFolderDataClients().getFolderTwoDetails();
		SortlyItemsPage page = initializeElements(SortlyItemsPage.class);
		new SortlyUserLoginTests().loginAsAdminWithValidCridentials(user);
		isEqual = isEqual & clickAddNewButton(page);
		isEqual = isEqual & clickOnAddFolderButton(page);
		isEqual = isEqual & sendKeysToNameTextBox(page, folderDetails.getName());
		isEqual = isEqual & sendKeysToTagsTextBox(page, folderDetails.getTagName());
		isEqual = isEqual & sendKeysToNotesTextBox(page, folderDetails.getNotes());
		isEqual = isEqual & clickOnAddButton(page);
		isEqual = isEqual & isFolderCreated(page, folderDetails.getName());
		isEqual = isEqual & deleteFolder(page, folderDetails.getName());
		if (isEqual)
			logPass("Add Folder & Delete Folder Admin Action Successful");
		else
			logFail("Add Folder & Delete Folder Admin Action Failed");

	}

	@Test(groups = { "createFolder&MoveFolder", "folder",
			"Admin" }, dataProvider = "Admin", dataProviderClass = SortlyUsersDataProvider.class, priority = 2)
	public void createFiveFolderAndMoveFolderByAdmin(UsersDTO user) throws InterruptedException {
		boolean isEqual = true;
		ArrayList<String> folderList = new ArrayList();
		int numberOfFolder = 5;
		int moveToLevelThirdFolder = 3;
		FolderDTO folderDetails = new SortlyFolderDataClients().getFolderTwoDetails();
		SortlyItemsPage page = initializeElements(SortlyItemsPage.class);
		new SortlyUserLoginTests().loginAsAdminWithValidCridentials(user);

		for (int i = 1; i <= numberOfFolder; i++) {
			String folderName = folderDetails.getName() + new Random().nextInt(100);
			folderList.add(folderName);
			isEqual = isEqual & clickAddNewButton(page);
			isEqual = isEqual & clickOnAddFolderButton(page);
			isEqual = isEqual & sendKeysToNameTextBox(page, folderName);
			isEqual = isEqual & sendKeysToTagsTextBox(page, folderDetails.getTagName());
			isEqual = isEqual & sendKeysToNotesTextBox(page, folderDetails.getNotes());
			isEqual = isEqual & clickOnAddButton(page);
			isEqual = isEqual & isFolderCreated(page, folderName);
			isEqual = isEqual & clickOnNewFolder(page, folderName);
		}
		String moveToFolder = folderList.get(numberOfFolder - moveToLevelThirdFolder);
		isEqual = isEqual & moveToFolder(page, moveToFolder, folderList.get(folderList.size() - 1));

		if (isEqual)
			logPass("Move 5th Folder to 3rd Folder Admin Action Successful");
		else
			logFail("Move 5th Folder to 3rd Folder Admin Action Failed");

	}

	@Test(groups = { "createFolder&MoveFolder", "folder",
			"Owner" }, dataProvider = "Owner", dataProviderClass = SortlyUsersDataProvider.class, priority = 3)
	public void createFiveFolderAndMoveFolderByOwner(UsersDTO user) throws InterruptedException {
		boolean isEqual = true;
		ArrayList<String> folderList = new ArrayList();
		int numberOfFolder = 5;
		int moveToLevelThirdFolder = 3;
		FolderDTO folderDetails = new SortlyFolderDataClients().getFolderTwoDetails();
		SortlyItemsPage page = initializeElements(SortlyItemsPage.class);
		new SortlyUserLoginTests().loginAsAdminWithValidCridentials(user);

		for (int i = 1; i <= numberOfFolder; i++) {
			String folderName = folderDetails.getName() + new Random().nextInt(100);
			folderList.add(folderName);
			isEqual = isEqual & clickAddNewButton(page);
			isEqual = isEqual & clickOnAddFolderButton(page);
			isEqual = isEqual & sendKeysToNameTextBox(page, folderName);
			isEqual = isEqual & sendKeysToTagsTextBox(page, folderDetails.getTagName());
			isEqual = isEqual & sendKeysToNotesTextBox(page, folderDetails.getNotes());
			isEqual = isEqual & clickOnAddButton(page);
			isEqual = isEqual & isFolderCreated(page, folderName);
			isEqual = isEqual & clickOnNewFolder(page, folderName);
		}
		String moveToFolder = folderList.get(numberOfFolder - moveToLevelThirdFolder);
		isEqual = isEqual & moveToFolder(page, moveToFolder, folderList.get(folderList.size() - 1));

		if (isEqual)
			logPass("Move 5th Folder to 3rd Folder Owner Action Successful");
		else
			logFail("Move 5th Folder to 3rd Folder Owner Action Failed");

	}

	@Test(groups = { "createFolder&CloneFolder", "folder",
			"Owner" }, dataProvider = "Owner", dataProviderClass = SortlyUsersDataProvider.class, priority = 4, enabled = true)
	public void addAndCloneFolderTestByOwner(UsersDTO user) {
		boolean isEqual = true;
		FolderDTO folderDetails = new SortlyFolderDataClients().getFolderOneDetails();
		SortlyItemsPage page = initializeElements(SortlyItemsPage.class);
		new SortlyUserLoginTests().loginAsOwnerWithValidCridentials(user);
		isEqual = isEqual & clickAddNewButton(page);
		isEqual = isEqual & clickOnAddFolderButton(page);
		isEqual = isEqual & sendKeysToNameTextBox(page, folderDetails.getName());
		isEqual = isEqual & sendKeysToTagsTextBox(page, folderDetails.getTagName());
		isEqual = isEqual & sendKeysToNotesTextBox(page, folderDetails.getNotes());
		isEqual = isEqual & clickOnAddButton(page);
		isEqual = isEqual & isFolderCreated(page, folderDetails.getName());
		if (isEqual)
			logPass("Clone Folder Owner Action Successful");
		else
			logFail("Clone Folder Owner Action Failed");

	}

	@Test(groups = { "createFolder&CloneFolder", "folder",
			"Admin" }, dataProvider = "Admin", dataProviderClass = SortlyUsersDataProvider.class, priority = 5, enabled = true)
	public void addAndCloneFolderTestByAdmin(UsersDTO user) {
		boolean isEqual = true;
		FolderDTO folderDetails = new SortlyFolderDataClients().getFolderOneDetails();
		SortlyItemsPage page = initializeElements(SortlyItemsPage.class);
		new SortlyUserLoginTests().loginAsOwnerWithValidCridentials(user);
		isEqual = isEqual & clickAddNewButton(page);
		isEqual = isEqual & clickOnAddFolderButton(page);
		isEqual = isEqual & sendKeysToNameTextBox(page, folderDetails.getName());
		isEqual = isEqual & sendKeysToTagsTextBox(page, folderDetails.getTagName());
		isEqual = isEqual & sendKeysToNotesTextBox(page, folderDetails.getNotes());
		isEqual = isEqual & clickOnAddButton(page);
		isEqual = isEqual & isFolderCreated(page, folderDetails.getName());
		if (isEqual)
			logPass("Clone Folder Admin Action Successful");
		else
			logFail("Clone Folder Admin Action Failed");

	}
}
