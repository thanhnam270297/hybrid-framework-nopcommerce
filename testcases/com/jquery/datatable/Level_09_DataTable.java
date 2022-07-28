package com.jquery.datatable;

import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_09_DataTable extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	@Test
	public void Table_01_Paging() {
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActivedByNumber("5"));
		
		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isPageActivedByNumber("10"));
		
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActivedByNumber("15"));
	}

	
	@Test
	public void Tabel_02_Actions() {
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
