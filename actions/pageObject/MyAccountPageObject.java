package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage{
	WebDriver driver;
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
