package javaBasic;

public class Topic_13_Dynamic_Locator {

	public static void main(String[] args) {
		/*
		 * // tầng UI String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']"; String
		 * SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']"; String ORDERS_PAGE_FOOTER =
		 * "//div[@class='footer']//a[text()='Orders']";
		 * 
		 * // tầng PageObject clickToElement(MY_ACCOUNT_PAGE_FOOTER); clickToElement(SEARCH_PAGE_FOOTER);
		 * clickToElement(ORDERS_PAGE_FOOTER);
		 */

		// %s là java string, đại diện cho 1 chuỗi truyền từ ngoài vào, truyền nó như là 1 tham số
		String DYNAMIC_ONE_PARAM = "//div[@id1='footer']//div[@id2='%s']";
		String DYNAMIC_TWO_PARAM = "//div[@id1='%s']//div[@id2='%s']";
		String DYNAMIC_THREE_PARAM = "//div[@id1='%s']//div[@id2='%s']//div[@id3='%s']";

		clickToElement(DYNAMIC_ONE_PARAM, "My account");
		clickToElement(DYNAMIC_ONE_PARAM, "Search");
		clickToElement(DYNAMIC_ONE_PARAM, "Orders");

		clickToElement(DYNAMIC_TWO_PARAM, "header", "My account");
		clickToElement(DYNAMIC_TWO_PARAM, "header", "Search");
		clickToElement(DYNAMIC_TWO_PARAM, "header", "Orders");
		
		clickToElement(DYNAMIC_THREE_PARAM, "Vietnam", "Saigon", "Pham Viet Chanh");
		clickToElement(DYNAMIC_THREE_PARAM, "Japan", "Tokyo", "Street 1");
		clickToElement(DYNAMIC_THREE_PARAM, "USA", "Colorado", "Street 2");
	}

	/*
	// fix cứng 1 locator 
	public static void clickToElement(String locator) { 
		System.out.println(locator); 
	}

	=============================================================

	// 1 tham số dynamic
	public static void clickToElement(String locator, String firstParam) {
		System.out.println(String.format(locator, firstParam));
		// //div[@class='footer']//a[text()='%s']
		// sẽ nhét pageName vào %s
	}

	=============================================================

	// 2 tham số dynamic
	public static void clickToElement(String locator, String firstParam, String secondParam) {
		System.out.println(String.format(locator, firstParam, secondParam));
	}

	=============================================================

	// 3 tham số dynamic
	public static void clickToElement(String locator, String firstParam, String secondParam, String thirdParam) {
		System.out.println(String.format(locator, firstParam, secondParam, thirdParam));
	}
	
	=============================================================
	*/
	
	// CHẠY ĐƯỢC CHO TẤT CẢ TỪ 1 -> N DYNAMIC PARAM
	// 1 hàm cho từ 1 đến n tham số dynamic -> rest parameter (java, c#, js)
	// khi truyền ... vào thì kiểu dữ liệu sẽ chuyển sang kiểu mảng String
	public static void clickToElement(String locator, String... params) {
		// phải ép kiểu tường minh params từ mảng String sang mảng Object (vì format là mảng object)
		System.out.println(String.format(locator, (Object[])params));
	}
}
