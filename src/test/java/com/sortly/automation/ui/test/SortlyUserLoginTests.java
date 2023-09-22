package com.sortly.automation.ui.test;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.sortly.automation.DTO.UsersDTO;
import com.sortly.automation.assertionhandler.Assertions;
import com.sortly.automation.dataprovider.SortlyUsersDataProvider;
import com.sortly.automation.ui.base.BaseClass;
import com.sortly.automation.ui.elements.SortlyLoginPageElements;
import com.sortly.automation.ui.page.SortlyUserLoginPage;
import com.sortly.automation.ui.utils.WaitUtils;

public class SortlyUserLoginTests extends BaseClass {
	private WaitUtils wait = new WaitUtils();

	@Test(groups = { "userLogin", "ownerLogin",
			"owner" }, dataProvider = "Owner", dataProviderClass = SortlyUsersDataProvider.class, priority = 1, enabled = true)
	public void loginAsOwnerWithValidCridentials(UsersDTO user) {
		boolean isEqual = true;
		SortlyUserLoginPage userLogin = PageFactory.initElements(getDriver(), SortlyUserLoginPage.class);

		isEqual = isEqual
				&& Assertions.assertEquals("Text " + SortlyLoginPageElements.logInToYourAccount + " Not Matching",
						SortlyLoginPageElements.logInToYourAccount, userLogin.getLoginToYourAccount().getText());
		userLogin.getEmail().sendKeys(user.getEmail());
		userLogin.getPassword().sendKeys(user.getPassword());
		userLogin.getContinueButton().click();
		wait.visibilityOf(userLogin.getAllItems());
		isEqual = isEqual && Assertions.assertEquals("Text " + SortlyLoginPageElements.dashboard + " Not Matching",
				SortlyLoginPageElements.dashboard, userLogin.getDashboard().getText());

		if (isEqual)
			logPass("Owner Successfully Loggedin");
		else
			logFail("Owner Login Action Failed");

	}

	@Test(groups = { "userLogin", "adminLogin",
			"admin" }, dataProvider = "Admin", dataProviderClass = SortlyUsersDataProvider.class, priority = 0, enabled = true)
	public void loginAsAdminWithValidCridentials(UsersDTO user) {
		boolean isEqual = true;
		SortlyUserLoginPage userLogin = PageFactory.initElements(getDriver(), SortlyUserLoginPage.class);

		isEqual = isEqual
				&& Assertions.assertEquals("Text " + SortlyLoginPageElements.logInToYourAccount + " Not Matching",
						SortlyLoginPageElements.logInToYourAccount, userLogin.getLoginToYourAccount().getText());
		userLogin.getEmail().sendKeys(user.getEmail());
		userLogin.getPassword().sendKeys(user.getPassword());
		userLogin.getContinueButton().click();
		wait.visibilityOf(userLogin.getAllItems());
		isEqual = isEqual && Assertions.assertEquals("Text " + SortlyLoginPageElements.dashboard + " Not Matching",
				SortlyLoginPageElements.dashboard, userLogin.getDashboard().getText());

		if (isEqual)
			logPass("Admin Successfully Loggedin");
		else
			logFail("Admin Login Action Failed");

	}

}
