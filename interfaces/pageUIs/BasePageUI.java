package pageUIs;

public class BasePageUI {
	// có 20 pages ở footer
	public static final String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
	public static final String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
	public static final String ORDERS_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
	
	// dùng 1 dynamic cho 20 pages
	public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
}
