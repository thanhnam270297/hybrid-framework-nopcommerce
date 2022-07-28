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
	public void Table_02_Input_Data() {
		homePage.inputToHeaderTextboxByName("Females", "276880");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Angola");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Males", "276472");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}
	
	@Test
	public void Table_03_Click_Icon() {
		homePage.clickToIconByCountryName("Angola", "remove");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByCountryName("Algeria", "remove");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByCountryName("Afghanistan", "edit");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToIconByCountryName("Albania", "edit");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}
	
	@Test
	public void Table_04_Verify_Row_Values() {
		homePage.inputToHeaderTextboxByName("Country", "Afghanistan");
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
