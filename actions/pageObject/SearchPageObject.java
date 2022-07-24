package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
