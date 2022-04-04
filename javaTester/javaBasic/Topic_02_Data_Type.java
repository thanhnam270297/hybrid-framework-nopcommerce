package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	/// primitive type, value type: kiểu dữ liệu nguyên thùy
	byte bNumber = 7;
	
	short sNumber = 7777;
	
	int iNumber = 77777;
	
	long lNumber = 777777;
	
	float fNumber = 77.77f;
	
	double dNumber = 77.77d;
	
	char cChar = '1';
	
	boolean bStatus = true;
	
	/// reference type (non-primitive): kiểu dữ liệu tham chiếu
	// String
	String address = "Ho Chi Minh";
	
	// Array
	String[] studentAddress = {address, "Ha Noi"};
	Integer[] studentNumber = {iNumber, 123456};
	
	// Class
	Topic_02_Data_Type topic;
	
	// Interface
	WebDriver driver;
	
	// Object
	Object oStudent;
	
	// Collection (List, Set, Map, Queue)
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	/* 2 kiểu dữ liệu khác nhau ntn:
	 * nguyên thủy thì ko có các hàm đi theo, còn tham chiếu thì có nhiều hàm đi theo
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
