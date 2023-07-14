package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStore extends TestBase{
	
	public YourStore() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "ul.list-inline>li:nth-of-type(2) a")
	private WebElement myAccountBtn;
	
	@FindBy(css = "ul.dropdown-menu>li:nth-of-type(2) a")
	private WebElement loginBtn;
	
	@FindBy(css = "ul.nav>li:nth-of-type(3)  a")
	private WebElement componentsBtn;
	
	@FindBy(xpath = "//a[text() = 'Monitors (2)']")
	private WebElement monitorsBtn;
	
	public YourStore clickMyAccountBtn() {
		myAccountBtn.click();
		return new YourStore();
	}
	
	public AccountLogin clickLoginBtn() {
		loginBtn.click();
		return new AccountLogin();
	}

	public YourStore clickComponentsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(componentsBtn)).click();
//		componentsBtn.click();
		return new YourStore();
	}
	
	public Monitors clickMonitorsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(monitorsBtn)).click();
//		monitorsBtn.click();
		return new Monitors();
	}
	
	@FindBy (css = "div.product-layout div.caption a")
	List<WebElement> productsList;
	
	public String navigateProducts(String productName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(productsList));
		for(int i = 0; i < productsList.size(); i++) {
			if(productsList.get(i).getText().equals(productName)) {
				productsList.get(i).click();
			}
		}
		return wd.getTitle();
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginLink;
	
	public void clickMyAccountLink() {
		myAccountLink.click();
	}
	
	public RegisterAccount clickRegisterLink() {
		registerLink.click();
		return new RegisterAccount();
	}
	
	@FindBy(xpath = "//div[contains(@class, 'swiper-container')]")
	private WebElement slider;
	
	@FindBy(xpath = "//div[contains(@class, 'swiper-container')]/div[contains(@class, 'swiper-wrapper')]/div[contains(@class, 'swiper-slide')]")
	private List<WebElement> sliderList;
	
	public void sliderSelection() {
		Actions actions = new Actions(wd);
		System.out.println(sliderList.size());
		for(int i = 0; i < sliderList.size(); i++) {
			actions.moveToElement(slider).perform();
			actions.clickAndHold().release().perform();
		}
	}

	@FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
	private WebElement wishListBtn;
	
	@FindBy(xpath = "//a[@id='wishlist-total']//span")
	private WebElement wishListNumber;
	
	public YourStore clickWishListBtn() {
				wait.until(ExpectedConditions.visibilityOfAllElements(wishListBtn));
				wishListBtn.click();  
				return new YourStore();
			}
			
			public String getWishListNumber() {
				wait.until(ExpectedConditions.visibilityOf(wishListNumber));
				return wishListNumber.getText();
			}
}
