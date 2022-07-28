package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Login: " + driver);
	}
	
	public void enterToEmailTextbox(String email) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
