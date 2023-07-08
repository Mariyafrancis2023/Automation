package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AppleCinema30;
import com.naveenautomationlabs.AutomationFramework.Pages.CheckOut;
import com.naveenautomationlabs.AutomationFramework.Pages.CheckoutDetails;
import com.naveenautomationlabs.AutomationFramework.Pages.Monitors;
import com.naveenautomationlabs.AutomationFramework.Pages.ShoppingCart;
import com.naveenautomationlabs.AutomationFramework.Pages.YourOrderHasBeenPlaced;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.Utils.Utils;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourOrderHasBeenPlacedTest extends TestBase{
	private YourStore yourStore;
	private Monitors monitor;
	private AppleCinema30 appleCinema;
	private ShoppingCart shoppingCart;
	private CheckOut checkout;
	private CheckoutDetails checkoutDetails;
	private YourOrderHasBeenPlaced orderPlaced;
	
	@BeforeMethod
	public void setup() {
		initialization();
		yourStore = new YourStore();
	}

	@Ignore
	@Test
	public void vaildateOrderHasBeenPlaced() {
		yourStore.clickComponentsBtn();
		monitor = yourStore.clickMonitorsBtn();
		appleCinema = monitor.clickAddToCartBtn();
		shoppingCart = appleCinema.addItemToShoppingCart();
		checkout = shoppingCart.clickCheckoutBtn();
		checkoutDetails = checkout.loginToAccount();
		orderPlaced = checkoutDetails.confirmOrder();
		Assert.assertEquals(orderPlaced.getYourOrderHasBeenPlacedTitle(), "Your order has been placed!", "incorrect page");
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}

