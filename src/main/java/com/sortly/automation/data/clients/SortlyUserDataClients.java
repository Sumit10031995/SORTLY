package com.sortly.automation.data.clients;

import com.sortly.automation.DTO.UsersDTO;
import com.sortly.automation.fileutils.JSONFileReader;

public class SortlyUserDataClients extends JSONFileReader {
	public String getDataSetPath() {
		return "src/test/resources/JSON/user.json";
	}

	public UsersDTO getUserDetails(String dataKey) {
		return getValue(dataKey, UsersDTO.class);
	}

	public UsersDTO getOwnerDetails() {
		return getUserDetails("OWNER");
	}

	public UsersDTO getAdminDetails() {
		return getUserDetails("ADMIN");
	}

}
