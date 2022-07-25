package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.OrderPageObject;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObject;
import pageObject.SearchPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {

	WebDriver driver;
	String emailAddress, password;
	BasePage basePage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);
		
		basePage = new BasePage();
		emailAddress = "namnguyen" + generateFakeNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomepageSliderDisplayed());
		
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstNameTextbox("Nam");
		registerPage.enterToLastNameTextbox("Nguyen");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		homePage = registerPage.clickToLogoutButton();
		System.out.println("Home Page = " + homePage.hashCode());

		Assert.assertTrue(homePage.isHomepageSliderDisplayed());
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		System.out.println("Home Page = " + homePage.hashCode());

		Assert.assertTrue(homePage.isHomepageSliderDisplayed());
	}
	
	@Test
	public void TC_03_Open_Page_At_Footer_Cach1() {
		// Home Page -> Search Page
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		
		// Search Page -> My Account Page
		myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByName(driver, "My account");
		
		// My Account Page -> Order Page
		orderPage = (OrderPageObject) myAccountPage.getFooterPageByName(driver, "Orders");
		
		// Order Page -> My Account Page
		myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByName(driver, "My account");
		
		// My Account Page -> Search Page
		searchPage = (SearchPageObject) myAccountPage.getFooterPageByName(driver, "Search");
		
		// Search Page -> Order Page
		orderPage = (OrderPageObject) searchPage.getFooterPageByName(driver, "Orders");
	}
	
	@Test
	public void TC_04_Open_Page_At_Footer_Cach2() {
		// Home Page -> Search Page
		homePage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		// Search Page -> My Account Page
		searchPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		// My Account Page -> Order Page
		myAccountPage.openFooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
		
		// Order Page -> My Account Page
		orderPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		// My Account Page -> Search Page
		myAccountPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		// Search Page -> Order Page
		searchPage.openFooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	OrderPageObject orderPage;
	MyAccountPageObject myAccountPage;
}
