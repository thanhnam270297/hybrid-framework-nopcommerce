package eclipseTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Access_Getter_Setter {

	WebDriver driver;
	
	
	
	public static void main(String[] args) {
		Topic_02_Getter_Setter topic02 = new Topic_02_Getter_Setter();
		topic02.setCarName("Lambogini Truck");
		System.out.println(topic02.getCarName());
	}
	
	/* camel case: testCase
	 * pascal case: TestCase (thường đặt cho tên Class, Interface, Method dành cho test case)
	 * 
	 */

}
