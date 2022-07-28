package pageObject.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

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
	}

	public void openPageByNumber(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.PAGING_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_NUMBER, pageNumber);
	}

	public boolean isPageActivedByNumber(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.PAGING_NUMBER_ACTIVED, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_NUMBER_ACTIVED, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
	}

	
	
	
}
