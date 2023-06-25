package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStore extends TestBase{
	
	public YourStore() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "ul.nav>li:nth-of-type(3)  a")
	private WebElement componentsBtn;
	
	@FindBy(xpath = "//a[text() = 'Monitors (2)']")
	private WebElement monitorsBtn;

	public YourStore clickComponentsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(componentsBtn)).click();
//		componentsBtn.click();
		return new YourStore();
	}
	
	public Monitors clickMonitorsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(monitorsBtn)).click();
//		monitorsBtn.click();
		return new Monitors();
	}
}
