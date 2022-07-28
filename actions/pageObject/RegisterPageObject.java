package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Register: " + driver);
	}
	
	public void clickToGenderMaleRadioButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void enterToFirstNameTextbox(String firstName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void enterToEmailTextbox(String email) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void enterToPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessMessageDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}
	
	public HomePageObject clickToLogoutButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
}
