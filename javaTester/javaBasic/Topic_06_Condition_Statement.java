package javaBasic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Topic_06_Condition_Statement {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	
	public void TC_01_IF() {
		boolean status = 5 > 3;
		System.out.println(status);
		
		// Hàm if sẽ nhận 1 điều kiện đúng
		// kiểm tra 1 điều kiện duy nhất
		// nếu điều kiện này đúng thì sẽ action trong phần thân của if
		if (status) {
			// đúng thì vào phần thân => sai thì bỏ qua
			System.out.println("Go to if");
		}
	}
	
	
	public void TC_02_IF_ELSE() {
		// có tới 2 điều kiện, nếu đúng thì vào if, sai thì vào else
		
		// nếu driver start với chrome, ff, edge, safari thì dùng hàm click
		// nếu driver start với IE thì dùng javascriptexecutor
		
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		System.out.println(driver.toString());
		
		if(driver.toString().contains("internet explorer")) {
			System.out.println("Click by JavaScript Excutor");
		} else {
			System.out.println("Click by Selenium Webdriver");
		}
		
	}

	@Parameters("browser")
	@Test
	public void TC_03_IF_ELSE_IF_ELSE(String browserName) {
		// có nhiều điều kiện
		// best practice: ko nên if else quá nhiều
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			// safari, opera, coccoc
			throw new RuntimeException("Please input correct the browser name!");
		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		
		driver.quit();
	}
	
	@Test
	public void TC_04_IF_ELSE() {
		int age =20;
		String access = (age < 18) ? "Can not access" : "Welcome!";
		
		if(age < 18) {
			access = "Can not access";
		} else {
			access = "Welcome!";
		}
		
		System.out.println(access);
	}
}
