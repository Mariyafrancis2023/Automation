package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AppleCinema30;
import com.naveenautomationlabs.AutomationFramework.Pages.CheckOut;
import com.naveenautomationlabs.AutomationFramework.Pages.Checkout2;
import com.naveenautomationlabs.AutomationFramework.Pages.Monitors;
import com.naveenautomationlabs.AutomationFramework.Pages.ShoppingCart;
import com.naveenautomationlabs.AutomationFramework.Pages.YourOrderHasBeenPlaced;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;


public class YourStoreTest extends TestBase {
	
	YourStore yourStore;
	Monitors monitor;
	AppleCinema30 appleCinema;
	ShoppingCart shoppingCart;
	CheckOut checkout;
	Checkout2 checkout2;
	YourOrderHasBeenPlaced orderPlaced;
	
	@BeforeMethod
	public void setup() {
		initialization();
		yourStore = new YourStore();
	}

	@Test
	public void vaildateBuyingMonitor() {
		yourStore.clickComponentsBtn();
		monitor = yourStore.clickMonitorsBtn();
		appleCinema = monitor.clickAddToCartBtn();
		shoppingCart = appleCinema.addItemToShoppingCart();
		checkout = shoppingCart.clickCheckoutBtn();
		checkout2 = checkout.clickLoginBtn();
		orderPlaced = checkout2.confirmOrder();
		Assert.assertEquals(orderPlaced.getYourStoreTitle(), "Your Store", "incorrect page");
		
	}
	
	@AfterMethod
	public void quit() {
//		tearDown();
	}
}
