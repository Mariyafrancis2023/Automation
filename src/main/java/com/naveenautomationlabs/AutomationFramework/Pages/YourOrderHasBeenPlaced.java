package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourOrderHasBeenPlaced extends TestBase {

	public YourOrderHasBeenPlaced () {
		PageFactory.initElements(wd, this);
	}
	
	public String getYourOrderHasBeenPlacedTitle() {
		sleep();
		return wd.getTitle();
	}
	
	public void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
