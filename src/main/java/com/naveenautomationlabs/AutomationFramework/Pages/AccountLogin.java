package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLogin extends TestBase{
	
	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input#input-email")
	private WebElement emailInput;
	
	@FindBy(css = "input#input-password")
	private WebElement passwordInput;
	
	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;
	
	public void enterEmail() {
		emailInput.sendKeys("tony@gmail.com");
	}
	
	public void enterPassword() {
		passwordInput.sendKeys("Password2");
	}  
	
	public void enterEmail(String username) {
		emailInput.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public MyAccount clickLoginBtn() {
		loginBtn.click();
		return new MyAccount();
	}
	
	public MyAccount loginToPortal() {
		enterEmail();
		enterPassword();
		return clickLoginBtn();
	}
}
