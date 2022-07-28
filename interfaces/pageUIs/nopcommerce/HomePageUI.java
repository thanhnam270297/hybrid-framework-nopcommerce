package pageUIs.nopcommerce;

public class HomePageUI {
	public static final String HOME_PAGE_SLIDER = "//div[@id='nivo-slider']";
	
	/* public: phạm vi rộng ngoài package
	 * static: biến tĩnh - cho phép 1 class khác truy cập đến biến của class này mà ko cần khởi tạo đối tượng của class này lên
	 * final: ngăn cản việc gán lại giá trị của biến này
	 * static final: hằng số constant - phải viết hoa và phân cách bởi dấu gạch _ HomePageUI.HOMEPAGE_SLIDER
	 * String: kiểu dữ liệu đại diện cho xpath
	 */
	
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	
}
