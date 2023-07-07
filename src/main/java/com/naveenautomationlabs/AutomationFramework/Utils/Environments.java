package com.naveenautomationlabs.AutomationFramework.Utils;

public enum Environments {
	
	DEV("Dev", "https://naveenautomationlabsDev.com/opencart/index.php?route=common/home"),
	STAGE("Stage", "https://naveenautomationlabsStage.com/opencart/index.php?route=common/home"),
	QA("qa", "https://naveenautomationlabsqa.com/opencart/index.php?route=common/home"),
	PROD("Production", "https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	String env;
	String url;
	
	Environments(String env, String URL) {
		this.env = env;
		this.url = URL;
	}

	public String getEnv() {
		return env;
	}

	public String getUrl() {
		return url;
	}
}
