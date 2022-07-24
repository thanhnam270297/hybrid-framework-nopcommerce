package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.OrderPageObject;
import pageObject.RegisterPageObject;
import pageObject.SearchPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Register_Login_Page_Switch_Page extends BaseTest {

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
	public void TC_03_Switch_Page_At_Footer() {
		// Home Page -> Search Page
		searchPage = homePage.openSearchPage(driver);
		
		// Search Page -> My Account Page
		myAccountPage = searchPage.openMyAccountPage(driver);
		
		// My Account Page -> Order Page
		orderPage = myAccountPage.openOrderPage(driver);
		
		// Order Page -> My Account Page
		myAccountPage = orderPage.openMyAccountPage(driver);
		
		// My Account Page -> Search Page
		searchPage = myAccountPage.openSearchPage(driver);
		
		// Search Page -> Order Page
		orderPage = searchPage.openOrderPage(driver);
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
