package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest {

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
		/// step 1: mở URL
		homePage = new HomePageObject(driver);

		/// step 2: verify homepage slider is displayed
		Assert.assertTrue(homePage.isHomepageSliderDisplayed());

		/// step 3: click register link >> register page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		/// step 4: click to gender radio button
		registerPage.clickToGenderMaleRadioButton();

		/// step 5: input first name
		registerPage.enterToFirstNameTextbox("Nam");

		/// step 6: input last name
		registerPage.enterToLastNameTextbox("Nguyen");

		/// step 7: input email
		registerPage.enterToEmailTextbox(emailAddress);

		/// step 8: input pw
		registerPage.enterToPasswordTextbox(password);

		/// step 9: input confirm pw
		registerPage.enterToConfirmPasswordTextbox(password);

		/// step 10: click register button
		registerPage.clickToRegisterButton();

		/// step 11: verify success message display
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		/// step 12: click to logout link >> homepage
		registerPage.clickToLogoutButton();
		homePage = new HomePageObject(driver);

		/// step 13: verify homepage slider is displayed
		Assert.assertTrue(homePage.isHomepageSliderDisplayed());
	}

	@Test
	public void TC_02_Login() {
		/// step 1: click login link
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		/// step 2: input email textbox
		loginPage.enterToEmailTextbox(emailAddress);

		/// step 3: input password textbox
		loginPage.enterToPasswordTextbox(password);

		/// step 4: click to login button
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

		/// step 5: verify homepage is displayed
		Assert.assertTrue(homePage.isHomepageSliderDisplayed());
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
}
