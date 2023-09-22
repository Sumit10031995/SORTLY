package com.sortly.automation.dataprovider;

import org.testng.annotations.DataProvider;

import com.sortly.automation.data.clients.SortlyUserDataClients;

public class SortlyUsersDataProvider {
	private static final SortlyUserDataClients userClient = new SortlyUserDataClients();

	@DataProvider(name = "Owner")
	public Object[][] getOwnerLoginDetails() {
		return new Object[][] { { userClient.getOwnerDetails() } };
	}

	@DataProvider(name = "Admin")
	public Object[][] getAdminLoginDetails() {
		return new Object[][] { { userClient.getAdminDetails() } };
	}
}
