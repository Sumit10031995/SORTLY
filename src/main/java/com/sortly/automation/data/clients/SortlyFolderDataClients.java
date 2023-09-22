package com.sortly.automation.data.clients;

import com.sortly.automation.DTO.FolderDTO;
import com.sortly.automation.fileutils.JSONFileReader;

public class SortlyFolderDataClients extends JSONFileReader {
	public String getDataSetPath() {
		return "src/test/resources/JSON/folderDetails.json";
	}

	public FolderDTO getFolder(String dataKey) {
		return getValue(dataKey, FolderDTO.class);
	}

	public FolderDTO getFolderOneDetails() {
		return getFolder("TestFolderOne");
	}

	public FolderDTO getFolderTwoDetails() {
		return getFolder("TestFolderTwo");
	}
}
