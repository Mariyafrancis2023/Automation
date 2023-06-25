package com.naveenautomationlabs.AutomationFramework.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AppleCinema30 extends TestBase {
	
	public AppleCinema30() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#input-option218>div:nth-of-type(2) input")
	private WebElement radioBtn;
	@FindBy(css = "input[name='option[223][]']")
	private WebElement checkboxBtn;
	@FindBy(css = "#input-option208")
	private WebElement textInput;
	@FindBy(css = "#input-option217")
	private WebElement selectDropDown;
	@FindBy(css = "#input-option209")
	private WebElement textareaInput;
	@FindBy(css = "#button-upload222")
	private WebElement uploadFileBtn;
	@FindBy(css = "button#button-cart")
	private WebElement addCartBtn;
	@FindBy(css = "div.alert-success")
	private WebElement successBanner;
//	@FindBy(xpath = "//a[text()='shopping cart']")
//	@FindBy(css = "div.alert-success a:nth-of-type(2)")
	@FindBy(css = "div#product-product div.alert-success a:nth-of-type(2)")
	private WebElement shoppingCartLink;
	
	public void clickRadioBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(radioBtn)).click();
//		radioBtn.click();
	}
	
	public void clickCheckboxBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(checkboxBtn)).click();
//		checkboxBtn.click();
	}
	
	public void enterTextField() {
		wait.until(ExpectedConditions.visibilityOf(textInput)).sendKeys("text field");
	//	textInput.sendKeys("text field");
	}
	
	public void selectFromDropDown() {
		Select sc = new Select(wait.until(ExpectedConditions.visibilityOf(selectDropDown)));
//		Select sc = new Select(selectDropDown);
		sc.selectByValue("1");
	}
	
	public void enterTextareaField() {
		wait.until(ExpectedConditions.visibilityOf(textareaInput)).sendKeys("text area field");
	//	textareaInput.sendKeys("text area field");
	}
	
	public void clickUploadFileBtn() {
		uploadFileBtn.click();
		try {
			Robot rb = new Robot();
			rb.delay(3000);
			//put the path of file in clipboard
			StringSelection ss = new StringSelection("C:\\Users\\me\\Desktop\\samplefile.txt");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rb.keyPress(KeyEvent.VK_CONTROL);  //press on ctrl key
			rb.keyPress(KeyEvent.VK_V);        //press on V key
			rb.delay(3000);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.delay(3000);
			rb.keyPress(KeyEvent.VK_ENTER);    //press on enter key
			rb.keyRelease(KeyEvent.VK_ENTER);
		//	sleep();
			wait.until(ExpectedConditions.alertIsPresent()).accept();;
		//	wd.switchTo().alert().accept();
		} catch (AWTException e) {
			e.printStackTrace();
		}			
	}
	
	public void clickAddToCartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addCartBtn)).click();
	//	addCartBtn.click();
	}
	
	public void getSuccessBannerText() {
		String banner = wait.until(ExpectedConditions.visibilityOf(successBanner)).getText();
		System.out.println(banner);
	//	successBanner.getText();
	}
	
	public ShoppingCart clickShoppingCartLink() {	
		wait.until(ExpectedConditions.visibilityOf(shoppingCartLink));
		shoppingCartLink.click();
//		sleep();
//		shoppingCartLink.click();
		return new ShoppingCart();
	}
	
	public ShoppingCart addItemToShoppingCart() {
		sleep();
//		clickRadioBtn();
		clickCheckboxBtn();
		enterTextField();
		selectFromDropDown();
		enterTextareaField();
		clickUploadFileBtn();
		clickAddToCartBtn();
		getSuccessBannerText();
		return clickShoppingCartLink();
	}
	
	public void sleep() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	