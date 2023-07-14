package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;


public class YourStoreTest extends TestBase {
	
	private YourStore yourStore;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		yourStore = new YourStore();
	}
	
	@Test
	public void validateSlider() {
		yourStore.sliderSelection();
		Assert.assertEquals(wd.getTitle(), "Samsung Galaxy Tab 10.1", "incorrect page");
	}
	
	@Test
	public void validateAddToWishList() {
		String initialWishListNumber = yourStore.getWishListNumber();
		yourStore.clickWishListBtn();
		waitUntilWishListNumberUpdates(initialWishListNumber);
		String updatedWishListNumber = yourStore.getWishListNumber();
		Assert.assertNotEquals(updatedWishListNumber, initialWishListNumber, "number did not changed");
	}

	public void waitUntilWishListNumberUpdates(String initialNumber) {
		int count = 0;
		while (count < 10) {
			if (!yourStore.getWishListNumber().equals(initialNumber)) {
				break;
			}
			count++;
		}
	}  

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
