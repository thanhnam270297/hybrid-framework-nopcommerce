package commons;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.ServiceGlobalModeOptions;

import pageObject.MyAccountPageObject;
import pageObject.OrderPageObject;
import pageObject.PageGeneratorManager;
import pageObject.SearchPageObject;
import pageUIs.BasePageUI;
import pageUIs.HomePageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.OrderPageUI;
import pageUIs.SearchPageUI;

public class BasePage {

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
		;
	}

	public void switchToTabByID(WebDriver driver, String expectedID) {
		Set<String> allTabID = driver.getWindowHandles();

		for (String id : allTabID) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToTabByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allTabIDs = driver.getWindowHandles();

		for (String id : allTabIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();

			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allTabIDs = driver.getWindowHandles();
		for (String id : allTabIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}

	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	
	// tạo 1 hàm get dynamic locator để ko bị trùng lặp
	public String getDynamicLocator(String xpathLocator, String... params) {
		return String.format(xpathLocator, (Object[]) params);
	}
	
	// hàm click cho n dynamic params
	public void clickToElement(WebDriver driver, String xpathLocator, String... params) {
		getWebElement(driver, getDynamicLocator(xpathLocator, params)).click();
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	
	// tương tự 1 hàm cho sendkey
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue, String... params) {
		WebElement element = getWebElement(driver, getDynamicLocator(xpathLocator, params));
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	// tương tự 1 hàm cho gettext
	public String getElementText(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textValue) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textValue);
	}

	public String getSelectedItemInDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedText) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(2);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		List<WebElement> childItems = driver.findElements(getByXpath(childXpath));
		for (WebElement tempElement : childItems) {
			if (tempElement.getText().trim().equals(expectedText)) {
				tempElement.click();
				sleepInSecond(1);
			} else {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tempElement);
				sleepInSecond(1);

				jsExecutor.executeScript("arguments[0].click();", tempElement);
				sleepInSecond(1);
			}
			break;
		}
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElemetnAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getElemetnCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String getHexaColorFromRgba(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	// tương tự 1 hàm cho isdisplay
	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isDisplayed();
	}

	public boolean isElementEnable(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	// 1 hàm tương tự cho waitForElementVisible
	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}
	
	public void waitForAllElementsVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	// 1 hàm tương tự cho waitForElementInvisible
	public void waitForElementInvisible(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}
	
	public void waitForAllElementsInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	// 1 hàm tương tự cho waitForElementClickable
	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(xpathLocator, params))));
	}
	
	/*-------giả sử có 20 page ở footer-------*/
	public SearchPageObject openSearchPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SEARCH_PAGE_FOOTER);
		clickToElement(driver, BasePageUI.SEARCH_PAGE_FOOTER);
		return PageGeneratorManager.getSearchPage(driver);
	}
	
	public MyAccountPageObject openMyAccountPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
		clickToElement(driver, BasePageUI.MY_ACCOUNT_PAGE_FOOTER);
		return PageGeneratorManager.getMyAccountPage(driver);
	}
	
	public OrderPageObject openOrderPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ORDERS_PAGE_FOOTER);
		clickToElement(driver, BasePageUI.ORDERS_PAGE_FOOTER);
		return PageGeneratorManager.getOrderPage(driver);
	}
	
	/*-------1 hàm cho 2 page, thêm các hàm click, wait, sendkey-------*/
	// case 1: page < 10 => dùng if else hoặc switch case
	// trả về BasePage vì là lớp cha của getSearchPage, getOrderPage, getMyAccountPage
	public BasePage getFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		
		if(pageName.equals("Search")) {
			return PageGeneratorManager.getSearchPage(driver);
		} else if(pageName.equals("Orders")) {
			return PageGeneratorManager.getOrderPage(driver);
		} else {
			return PageGeneratorManager.getMyAccountPage(driver);
		}
	}
	
	// case 2: multiple page
	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_FOOTER, pageName);
	}
	
	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
}
