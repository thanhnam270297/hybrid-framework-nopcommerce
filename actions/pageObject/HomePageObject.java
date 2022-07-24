package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;
	
	/// hàm khởi tạo - constructor
	public HomePageObject(WebDriver driver) {
		/* khi new 1 class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		 * 1 hàm khởi tạo sẽ có cùng tên vs class
		 * ko có kiểu trả về
		 * 1 class có thể có nhiều hàm khởi tạo -> tính chất đa hình
		*/
		this.driver = driver;
		System.out.println("Home: " + driver);
	}
	
	public boolean isHomepageSliderDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);

	}
}
