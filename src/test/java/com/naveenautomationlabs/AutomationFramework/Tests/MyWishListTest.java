package com.naveenautomationlabs.AutomationFramework.Tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.MyWishList;
import com.naveenautomationlabs.AutomationFramework.Pages.MyWishList.MyWishListTableHeader;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyWishListTest extends TestBase{
	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private MyWishList wishList;
	
	@BeforeMethod
	public void setup() {
		initialization();
		yourStore = new YourStore();
	}
	
	@Test
	public void validateUnitPrice() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal();
		wishList = myAccount.clickWishListBtn();
//		int index = wishList.getIndexOfColumn(MyWishListTableHeader.UNIT_PRICE);
//		System.out.println(index);
		WebElement element = wishList.getCellElementFromTable(MyWishListTableHeader.UNIT_PRICE, "MacBook");
		System.out.println(element.getText());
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}
