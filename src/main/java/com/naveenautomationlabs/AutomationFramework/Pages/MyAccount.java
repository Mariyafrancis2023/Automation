package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccount extends TestBase{

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "ul.list-inline>li:nth-of-type(3)")
	WebElement wishListBtn;
	
	public MyWishList clickWishListBtn() {
		wishListBtn.click();
		return new MyWishList();
	}
}
