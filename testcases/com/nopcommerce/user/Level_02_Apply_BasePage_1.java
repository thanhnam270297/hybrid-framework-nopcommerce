package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BasePage;
import org.testng.annotations.BeforeClass;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_1 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	BasePage basePage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		basePage = new BasePage();
		
		emailAddress = "namnguyen" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		
		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		/// cách 1: assert true xem có display ko
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//span[@id='FirstName-error']"));
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//span[@id='LastName-error']"));
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//span[@id='Email-error']"));

		/// cách 2: assert equal để so sánh text get được vs text mong muốn
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nam");

		/// truyền vào email sai
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("namnguyen@gmail");

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1234567");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'message-error')]//li")).getText(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Successfully() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nam");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1234567");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nam");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("1234567");

		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'message-error')]//li")).getText(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Characters() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nam");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123");
		
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Invalid_Confirm_Password() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Nguyen");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Nam");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("654321");
		
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

}
