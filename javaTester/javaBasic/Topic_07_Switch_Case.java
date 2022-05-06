package javaBasic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Topic_07_Switch_Case {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);

	@Parameters("browser")
	@Test
	public void TC_01(String browserName) {
		driver = getBrowserDriver(browserName);
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		
		driver.quit();
	}
	
	@Test
	public void TC_02() {
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:	
			System.out.println("Tháng có 31 ngày");
			break;
			/// nếu ko có break thì sẽ chạy tất cả các case, sẽ chạy luôn default
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng có 30  ngày");
			break;
		case 2:
			System.out.println("Tháng có 28 ngày");
			break;
		default:
			System.out.println("Vui lòng nhập tháng từ 1 đến 12!");
			break;
		}
	}

	public void TC_03() {
		
		/// only convertible int values, strings or enum variables ( = constant) are permitted
		
		int diem1 = scanner.nextInt();
		
		String ten = scanner.nextLine();
		
		/// nhược điểm:
		/// chỉ dùng đc với int string enum
		/// ko dùng các toán tử trong case đc: > < == != ...
		switch (ten) {
		case "Nam":
			
			break;
		default:
			break;
		}
		
		////////----------------------------////
		float diem = scanner.nextFloat();
		
		/// nhược điểm:
		/// khó đọc code
		/// ko check trùng lập
		if(10 >= diem && diem >= 8.5) {
			System.out.println("Điểm A");
		} else if(8.5 > diem && diem >= 7.5) {
			System.out.println("Điểm B");
		} else if(7.5 > diem && diem >= 5) {
			System.out.println("Điểm C");
		} else if(5 > diem && diem >= 0){
			System.out.println("Điểm D");
		} else {
			System.out.println("Nhập điểm lại");
		}
	}
	
	@Test
	public void TC_04() {
		int firstNumber = scanner.nextInt();
		int secondNumber = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+":
			System.out.println("A + B = " + (firstNumber + secondNumber));
			break;
		case "-":
			System.out.println("A - B = " + (firstNumber - secondNumber));
			break;
		case "*":
			System.out.println("A * B = " + (firstNumber * secondNumber));
			break;
		case "/":
			System.out.println("A / B = " + (firstNumber / secondNumber));
			break;
		case "%":
			System.out.println("A % B = " + (firstNumber % secondNumber));
			break;	
		default:
			break;
		}
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			new RuntimeException("Please input correct the browser name!");
			break;
		}
		return driver;
	}
}
