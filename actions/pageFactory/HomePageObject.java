package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {

	WebDriver driver;
	
	
	///--------------- UI -------------------------///
	/// Page Factory
	/// @FindBy(how = How.ID, using = "nivo-slider")
	@FindBy(id = "nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className = "ico-register")
	WebElement registerLink;
	
	@FindBy(className = "ico-login")
	WebElement loginLink;
	
	/*
	@FindBy(className = "ico-login")
	List<WebElement> loginLink;
	*/
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	///--------------- ACTION -------------------------///
	public boolean isHomepageSliderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}
}
