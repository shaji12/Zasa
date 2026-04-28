package base;

import java.time.Duration;

import config.ConfigReader;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeMethod
	public void setup(){
		String browser = ConfigReader.get("browser");
		String url = ConfigReader.get("url");
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver().get(url);
	}
	@AfterMethod
	public void tearDown(){
		DriverFactory.quitDriver();
	}

	
//	protected WebDriver driver;
	
//	@BeforeMethod
//	public void setUp() {
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//
//		// Implicit Wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//
//		driver.get("https://store-qa.globtech.in/login");
//
//	}
//
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

}
