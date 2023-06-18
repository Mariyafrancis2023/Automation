package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Monitors extends TestBase {
	
	public Monitors() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement addToCartBtn;
	
	public AppleCinema30 clickAddToCartBtn() {
		addToCartBtn.click();
		return new AppleCinema30();
	}

}

