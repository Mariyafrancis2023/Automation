package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourOrderHasBeenPlaced extends TestBase {

	public YourOrderHasBeenPlaced () {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;
	
	public YourStore clickContinueBtn() {
		continueBtn.click();
		return new YourStore();
	}
	
	public String getYourStoreTitle() {
		return wd.getTitle();
	}
}
