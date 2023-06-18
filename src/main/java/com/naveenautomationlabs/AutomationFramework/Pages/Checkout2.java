package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Checkout2 extends TestBase {

	public Checkout2 () {
		PageFactory.initElements(wd, this);
	}
//billing details
	@FindBy(css = "#input-payment-firstname")
	WebElement firstNameInput;
	@FindBy(css = "#input-payment-lastname")
	WebElement lastNameInput;	
	@FindBy(css = "#input-payment-company")
	WebElement companyNameInput;
	@FindBy(css = "#input-payment-address-1")
	WebElement address1Input;
	@FindBy(css = "#input-payment-address-2")
	WebElement address2Input;	
	@FindBy(css = "#input-payment-city")
	WebElement cityInput;
	@FindBy(css = "#input-payment-postcode")
	WebElement postcodeInput;
	@FindBy(css = "#input-payment-country")
	WebElement countryInput;	
	@FindBy(css = "#input-payment-zone")
	WebElement regionInput;
	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

//delivery details	
	@FindBy(css = "input[name='shipping_address']")
	WebElement shippingAddressRadioBtn;
	@FindBy(css = "input#button-shipping-address")
	WebElement shippingContinueBtn;

//delivery method
	@FindBy(css = "input[name='shipping_method']")
	WebElement shippingRateRadioBtn;
	@FindBy(css = "input#button-shipping-method")
	WebElement shippingMethodContinueBtn;

//payment method
	@FindBy(css = "input[name='agree']")
	WebElement checkbox;
	@FindBy(css = "input#button-payment-method")
	WebElement paymentContinueBtn;

//confirm order
	@FindBy(css = "input#button-confirm")
	WebElement confirmBtn;

	//enter billing details
	public void enterFirstName() {
		firstNameInput.sendKeys("tony");
	}
	public void enterLastName() {
		lastNameInput.sendKeys("steve");	
	}
	public void enterCompanyName() {
		companyNameInput.sendKeys("abcd");
	}	
	public void enterAddress1() {
		address1Input.sendKeys("ontario");
	}	
	public void enterAddress2() {
		address2Input.sendKeys("north");
	}	
	public void enterCity() {
		cityInput.sendKeys("west");
	}	
	public void enterPostCode() {
		postcodeInput.sendKeys("12345");
	}	
	public void selectCountry() {
		Select sc = new Select(countryInput);
		sc.selectByValue("38");
	}	
	public void selectRegion() {
		Select sc = new Select(regionInput);
		sc.selectByValue("3532");
	}	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	//enter delivery details
	public void clickRadioBtn() {
		shippingAddressRadioBtn.click();
	}	
	public void clickShippingContinueBtn() {
		shippingContinueBtn.click();
	}
	
	//enter delivery method
	public void clickShippingRateRadioBtn() {
		shippingRateRadioBtn.click();
	}
	public void clickShippingMethodContinueBtn() {
		shippingMethodContinueBtn.click();
	}
	
	//enter payment method
	public void clickCheckbox() {
		checkbox.click();
	}
	public void clickPaymentContinueBtn() {
		paymentContinueBtn.click();
	}
	
	public YourOrderHasBeenPlaced clickConfirmBtn() {
		confirmBtn.click();
		return new YourOrderHasBeenPlaced();
	}
	
	public YourOrderHasBeenPlaced confirmOrder() {
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
		clickRadioBtn();
		clickShippingContinueBtn();
		clickShippingRateRadioBtn();
		clickShippingMethodContinueBtn();
		clickCheckbox();
		clickPaymentContinueBtn();
		return clickConfirmBtn();
	}
}
