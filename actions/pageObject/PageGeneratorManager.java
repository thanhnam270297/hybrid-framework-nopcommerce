package pageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	/// tạo ra các biến static chỉ cho phép dùng trong class, nếu có final thì sẽ ko đc phép gán ở dưới [homePage = new HomePageObject(driver);]
	private static HomePageObject homePage;
	private static LoginPageObject loginPage;
	private static RegisterPageObject registerPage;
	private static MyAccountPageObject myAccountPage;
	private static SearchPageObject searchPage;
	private static OrderPageObject orderPage;
	
	/// tạo ra contractor này để ko cho phép truy cập từ bên ngoài
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		if(myAccountPage == null) {
			myAccountPage = new MyAccountPageObject(driver);
		}
		return myAccountPage;
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		if(searchPage == null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		if(orderPage == null) {
			orderPage = new OrderPageObject(driver);
		}
		return orderPage;
	}
}
