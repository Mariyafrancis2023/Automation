package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AppleCinema30;
import com.naveenautomationlabs.AutomationFramework.Pages.Monitors;
import com.naveenautomationlabs.AutomationFramework.Pages.ShoppingCart;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class ShoppingCartTest extends TestBase {
	
	private YourStore yourStore;
	private Monitors monitor;
	private AppleCinema30 appleCinema;
	private ShoppingCart shoppingCart;
	
	@BeforeMethod
	public void setup() {
		initialization();
		yourStore = new YourStore();
	}
	
	@Test
	public void vaildateProductAvailability() {
		yourStore.clickComponentsBtn();
		monitor = yourStore.clickMonitorsBtn();
		appleCinema = monitor.clickAddToCartBtn();
		shoppingCart = appleCinema.addItemToShoppingCart();
		shoppingCart.clickCheckoutBtn();
		Assert.assertEquals(shoppingCart.getBannerText(), shoppingCart.getBannerText(), "incorrect message displayed");
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}

}
