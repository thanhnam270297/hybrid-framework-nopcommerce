package pageObject.jQuery;

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

	
	
	
}
