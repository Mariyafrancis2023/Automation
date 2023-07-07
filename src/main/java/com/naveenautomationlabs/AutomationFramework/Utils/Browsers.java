package com.naveenautomationlabs.AutomationFramework.Utils;

public enum Browsers {

	CHROME("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox");

	String nameOfBrowser;
	
	Browsers(String nameOfBrowser) {
		this.nameOfBrowser = nameOfBrowser;
	}

	public String getNameOfBrowser() {
		return nameOfBrowser;
	}
}
