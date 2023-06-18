package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class CheckOut extends TestBase {

	public CheckOut () {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "#input-email")
	WebElement emailInput;
	@FindBy(css = "#input-password")
	WebElement passwordInput;
	@FindBy(css = "input[value = 'Login']")
	WebElement loginBtn;
	
	public void enterEmail() {
		emailInput.sendKeys("tony@gmail.com");
	}
	
	public void enterPassword() {
		passwordInput.sendKeys("Password2");
	}
	
	public Checkout2 clickLoginBtn() {
		loginBtn.click();
		return new Checkout2();
	}
	
	public Checkout2 loginToAccount() {
		enterEmail();
		enterPassword();
		return clickLoginBtn();
	}
}
