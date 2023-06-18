package com.naveenautomationlabs.AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AppTest extends TestBase{
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
    @Test
    public void validateTitle(){
      Assert.assertEquals(wd.getTitle(),"Your Store", "Incorrect page");
    }
    @Test
    public void test() {
    WebElement componentsBtn = wd.findElement(By.cssSelector("ul.nav>li:nth-of-type(3)  a"));
    componentsBtn.click();    	
    WebElement monitorsBtn = wd.findElement(By.xpath("//a[text() = 'Monitors (2)']"));
    monitorsBtn.click();
    System.out.println(wd.getTitle());
    WebElement addToCartBtn = wd.findElement(By.xpath("//span[text()='Add to Cart']"));
//    WebElement addToCartBtn = wd.findElement(By.cssSelector("button[onclick='cart.add('42', '2');']"));
    addToCartBtn.click(); 
    System.out.println(wd.getTitle());
    }
    @AfterMethod
    public void quit() {
  //  	tearDown();
    }
}
