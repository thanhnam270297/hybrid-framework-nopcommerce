package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/// chứa các hàm dùng chung cho nguyên sourcefolder testcases
public class BaseTest {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	private enum BROWSER {
		CHROME, FIREFOX, EDGE_LEGACY, EDGE_CHROMIUM, IE, SAFARI, H_CHROME, H_FIREFOX;
	}
	
	private enum OS {
		WINDOWS, MAC_OSX, LINUX;
	}
	
	private enum PLATFORM {
		WINDOW_PHONE, IOS, ANDROID;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		if(browser == BROWSER.CHROME) {
			/* check browser version hiện tại là bao nhiêu
			 * tải về
			 * init browser lên
			 * chạy trên được nhiều OS
			*/
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		} else if(browser == BROWSER.FIREFOX) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		} else if(browser == BROWSER.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GlobalConstants.DEV_APP_URL_STRING);
		return driver;
	}
	
	/// chạy cho nhiều trình duyệt, nhiều app
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		if(browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browser == BROWSER.EDGE_CHROMIUM) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}
	
}
