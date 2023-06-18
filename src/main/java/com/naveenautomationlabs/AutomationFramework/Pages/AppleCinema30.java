package com.naveenautomationlabs.AutomationFramework.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AppleCinema30 extends TestBase {
	
	public AppleCinema30() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-option218>div:nth-of-type(2) input")
	WebElement radioBtn;
	@FindBy(css = "input[name='option[223][]']")
	WebElement checkboxBtn;
	@FindBy(css = "#input-option208")
	WebElement textInput;
	@FindBy(css = "#input-option217")
	WebElement selectDropDown;
	@FindBy(css = "#input-option209")
	WebElement textareaInput;
	@FindBy(css = "#button-upload222")
	WebElement uploadFileBtn;
	@FindBy(css = "button#button-cart")
	WebElement addCartBtn;
	@FindBy(css = "div.alert-success")
	WebElement successBanner;
	@FindBy(css = "div.alert-success>a:last-of-type")
	WebElement shoppingCartLink;
	
	public void clickRadioBtn() {
		radioBtn.click();
	}
	
	public void clickCheckboxBtn() {
		checkboxBtn.click();
	}
	
	public void enterTextField() {
		textInput.sendKeys("text field");
	}
	
	public void selectFromDropDown() {
		Select sc = new Select(selectDropDown);
		sc.selectByValue("1");
	}
	
	public void enterTextareaField() {
		textareaInput.sendKeys("text area field");
	}
	
	public void clickUploadFileBtn() {
		uploadFileBtn.click();
		try {
			Robot rb = new Robot();
			rb.delay(3000);
//			StringSelection ss = new StringSelection("C:\\Users\\me\\Desktop\\samplefile.txt");
			StringSelection ss = new StringSelection("sample.txt");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.delay(3000);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(3000);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			wd.switchTo().alert().accept();
		} catch (AWTException e) {
			e.printStackTrace();
		}	
	}
	
	public void clickAddToCartBtn() {
		addCartBtn.click();
	}
	
	public void getSuccessBannerText() {
		successBanner.getText();
	}
	
	public ShoppingCart clickShoppingCartLink() {
		shoppingCartLink.click();
		return new ShoppingCart();
	}
	
	public ShoppingCart addItemToShoppingCart() {
		clickRadioBtn();
		clickCheckboxBtn();
		enterTextField();
		selectFromDropDown();
		enterTextareaField();
		clickUploadFileBtn();
		clickAddToCartBtn();
		getSuccessBannerText();
		return clickShoppingCartLink();
	}
}
	