package com.sortly.automation.enumhandler;

public class EnumManager {

	public enum RBAC {
		OWNER("OWNER"), MANAGER("MANAGER");

		private final String name;

		RBAC(String name) {
			this.name = name;
		}

		public String getName() {
			return name;

		}

	}
}
