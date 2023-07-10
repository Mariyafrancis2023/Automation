package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.Utils.ExcelUtils;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLoginTest extends TestBase {

	private YourStore yourStore;
	private AccountLogin accountLogin;
	
	@BeforeMethod
	public void setup() {
//		String browserName = System.getProperty("browser");
//		initialization(browserName);
		initialization();
		yourStore = new YourStore();
	}
	
	@Test(dataProvider = "login_data")
	public void validateLogin(String username, String Password) {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		accountLogin.enterEmail(username);
		accountLogin.enterPassword(Password);
		accountLogin.clickLoginBtn();
		Assert.assertEquals(wd.getTitle(), "My Account", "wrong page");
	}
	
	@DataProvider(name = "login_data")
	public String[][] getDataFromExcelSheet() throws Exception {
		String filePath = "C:\\Users\\me\\Desktop\\TestData.xlsx";
		int rowCnt = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCnt = ExcelUtils.getCellCount(filePath, "Sheet1", rowCnt);
//		String cellData = ExcelUtils.getCellData(filePath, "Sheet1", rowCnt, colCnt);
		String [][] virtualSheet = new String [rowCnt][colCnt];
		for(int i = 1; i <= rowCnt; i++) {
			for(int j = 0; j < colCnt; j++) {
				virtualSheet[i-1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}
		return virtualSheet;
	}
	
	@AfterMethod
	public void quit() {
		tearDown();
	}
}
