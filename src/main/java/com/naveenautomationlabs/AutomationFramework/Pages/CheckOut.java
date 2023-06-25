package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class CheckOut extends TestBase {

	public CheckOut () {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "#input-email")
	private WebElement emailInput;
	@FindBy(css = "#input-password")
	private WebElement passwordInput;
	@FindBy(css = "input[value = 'Login']")
	private WebElement loginBtn;
	
	public void enterEmail() {
		wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys("stevetom2@email.com");
//		emailInput.sendKeys("stevetom2@email.com");
	}
	
	public void enterPassword() {
		wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys("Tomsteve2");
//		passwordInput.sendKeys("Tomsteve2");
	}
	
	public CheckoutDetails clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
//		loginBtn.click();
		return new CheckoutDetails();
	}
	
	public CheckoutDetails loginToAccount(){
		enterEmail();
		enterPassword();
		return clickLoginBtn();
	}
}
