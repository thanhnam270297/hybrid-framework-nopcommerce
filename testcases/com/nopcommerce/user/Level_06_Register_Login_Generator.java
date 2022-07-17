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

public class Level_06_Register_Login_Generator extends BaseTest {

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
		
		homePage = new HomePageObject(driver);
		System.out.println("Home Page = " + homePage.hashCode());
	}

	@Test
	public void TC_01_Register() {

		Assert.assertTrue(homePage.isHomepageSliderDisplayed());

		/// tạo kết nối giữa 2 page; che giấu khỏi tạo dữ liệu trên tầng testcase
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstNameTextbox("Nam");
		registerPage.enterToLastNameTextbox("Nguyen");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		/// tạo kết nối giữa 2 page; che giấu khỏi tạo dữ liệu trên tầng testcase
		homePage = registerPage.clickToLogoutButton();
		System.out.println("Home Page = " + homePage.hashCode());

		Assert.assertTrue(homePage.isHomepageSliderDisplayed());
	}

	@Test
	public void TC_02_Login() {
		
		/// tạo kết nối giữa 2 page; che giấu khỏi tạo dữ liệu trên tầng testcase
		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		System.out.println("Home Page = " + homePage.hashCode());

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
