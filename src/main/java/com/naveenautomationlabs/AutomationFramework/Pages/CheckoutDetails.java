package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class CheckoutDetails extends TestBase {

	public CheckoutDetails () {
		PageFactory.initElements(wd, this);
	}
//billing details
	@FindBy(css = "input[value='new']")
	private WebElement newAddressRadioBtn;
	@FindBy(css = "#input-payment-firstname")
	private WebElement firstNameInput;
	@FindBy(css = "#input-payment-lastname")
	private WebElement lastNameInput;	
	@FindBy(css = "#input-payment-company")
	private WebElement companyNameInput;
	@FindBy(css = "#input-payment-address-1")
	private WebElement address1Input;
	@FindBy(css = "#input-payment-address-2")
	private WebElement address2Input;	
	@FindBy(css = "#input-payment-city")
	private WebElement cityInput;
	@FindBy(css = "#input-payment-postcode")
	private WebElement postcodeInput;
	@FindBy(css = "#input-payment-country")
	private WebElement countryInput;	
	@FindBy(css = "#input-payment-zone")
	private WebElement regionInput;
	@FindBy(css = "input[value='Continue']")
	private WebElement continueBtn;

//delivery details	
	@FindBy(css = "input[name='shipping_address']")
	private WebElement shippingAddressRadioBtn;
	@FindBy(css = "input#button-shipping-address")
	private WebElement shippingContinueBtn;

//delivery method
	@FindBy(css = "input[name='shipping_method']")
	private WebElement shippingRateRadioBtn;
	@FindBy(css = "input#button-shipping-method")
	private WebElement shippingMethodContinueBtn;

//payment method
	@FindBy(css = "input[name='agree']")
	private WebElement checkbox;
	@FindBy(css = "input#button-payment-method")
	private WebElement paymentContinueBtn;

//confirm order
	@FindBy(css = "input#button-confirm")
	private WebElement confirmBtn;

	//enter billing details
	public void clickAddressRadioBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(newAddressRadioBtn)).click();
//		newAddressRadioBtn.click();
	}
	public void enterFirstName() {
		wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys("tony");
//		firstNameInput.sendKeys("tony");
	}
	public void enterLastName() {
		wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys("steve");
//		lastNameInput.sendKeys("steve");	
	}
	public void enterCompanyName() {
		wait.until(ExpectedConditions.visibilityOf(companyNameInput)).sendKeys("abcd");
//		companyNameInput.sendKeys("abcd");
	}	
	public void enterAddress1() {
		wait.until(ExpectedConditions.visibilityOf(address1Input)).sendKeys("ontario");
//		address1Input.sendKeys("ontario");
	}	
	public void enterAddress2() {
		wait.until(ExpectedConditions.visibilityOf(address2Input)).sendKeys("north");
//		address2Input.sendKeys("north");
	}	
	public void enterCity() {
		wait.until(ExpectedConditions.visibilityOf(cityInput)).sendKeys("west");
//		cityInput.sendKeys("west");
	}	
	public void enterPostCode() {
		wait.until(ExpectedConditions.visibilityOf(postcodeInput)).sendKeys("12345");
//		postcodeInput.sendKeys("12345");
	}	
	public void selectCountry() {
		selectFromDropDownMenu(countryInput,"38");	
//		Select sc = new Select(countryInput);
//		sc.selectByValue("38");
	}	
	public void selectRegion() {
		selectFromDropDownMenu(regionInput,"Alberta");
//		Select sc = new Select(regionInput);
//		sc.selectByVisibleText("Alberta");
	}	
	public void clickContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
//		continueBtn.click();
	}
	private void selectFromDropDownMenu(WebElement element, String text) {
		Select sc = new Select(element);
		try {
			sc.selectByVisibleText(text);
		}catch(NoSuchElementException e) {
			sc.selectByValue(text);
		}

	}
	
	//enter delivery details
	public void clickRadioBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(shippingAddressRadioBtn)).click();
//		shippingAddressRadioBtn.click();
	}	
	public void clickShippingContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(shippingContinueBtn)).click();
//		shippingContinueBtn.click();
	}
	
	//enter delivery method
	public void clickShippingRateRadioBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(shippingRateRadioBtn)).click();
//		shippingRateRadioBtn.click();
	} 
	public void clickShippingMethodContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueBtn)).click();
//		shippingMethodContinueBtn.click();
	}
	
	//enter payment method
	public void clickCheckbox() {
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
//		checkbox.click();
	}
	public void clickPaymentContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(paymentContinueBtn)).click();
//		paymentContinueBtn.click();
	}
	
	public YourOrderHasBeenPlaced clickConfirmBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
//		confirmBtn.click();
		return new YourOrderHasBeenPlaced();
	}
	
	public YourOrderHasBeenPlaced confirmOrder() {
		clickAddressRadioBtn();
		enterFirstName();
		enterLastName();
		enterCompanyName();
		enterAddress1();
		enterAddress2();
		enterCity();
		enterPostCode();
		selectCountry();
		selectRegion();
		clickContinueBtn();
//		clickRadioBtn();
		clickShippingContinueBtn();
//		clickShippingRateRadioBtn();
		clickShippingMethodContinueBtn();
		clickCheckbox();
		clickPaymentContinueBtn();
		return clickConfirmBtn();
	}
}
