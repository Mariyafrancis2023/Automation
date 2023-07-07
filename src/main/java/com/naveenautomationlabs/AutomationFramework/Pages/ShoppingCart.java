package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class ShoppingCart extends TestBase{

	public ShoppingCart() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElement checkoutBtn;
	
	@FindBy(css = "div[class='alert alert-danger alert-dismissible']")
	private WebElement bannerText;
	
	public CheckOut clickCheckoutBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
	//	checkoutBtn.click();
		return new CheckOut();
	}
	
	public String getBannerText() {
		String bannerMessage = wait.until(ExpectedConditions.visibilityOf(bannerText)).getText();
		System.out.println(bannerMessage);
		return bannerMessage;
	}
}
